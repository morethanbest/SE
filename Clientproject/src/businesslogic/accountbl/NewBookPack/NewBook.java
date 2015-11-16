package businesslogic.accountbl.NewBookPack;

import java.util.ArrayList;
import java.util.List;

import po.CommodityLocation;
import po.OrignalAccountPO;
import po.OrignalCommodityPO;
import po.OrignalOrganizationPO;
import po.OrignalStaffPO;
import po.OrignalVehiclesPO;
import vo.AccountVO;
import vo.CommodityInVO;
import vo.NewbookVO;
import vo.OrganizationVO;
import vo.ResultMessage;
import vo.StaffVO;
import vo.VehicleVO;

public class NewBook {
	MockCreateNewBook newBook;
	MockIdInfo id;
	MockOrignalComID ocid;
	MockOrignalOrganID ooid;
	MockOrignalStaffID osid;
	public NewBook(MockCreateNewBook newBook,MockIdInfo id,MockOrignalComID ocid,MockOrignalOrganID ooid,MockOrignalStaffID osid){
		this.newBook=newBook;
		this.id=id;
		this.ocid=ocid;
		this.ooid=ooid;
		this.osid=osid;
	}
	public ResultMessage CreateNewBook(NewbookVO vo){
		//Ê±¼ä
		long time=0;
		List<OrignalAccountPO> account = new ArrayList<OrignalAccountPO>();
		List<OrignalCommodityPO> commodity = new ArrayList<OrignalCommodityPO>();
		List<OrignalOrganizationPO> organization =new ArrayList<OrignalOrganizationPO>();
		List<OrignalStaffPO> staff = new ArrayList<OrignalStaffPO>();
		List<OrignalVehiclesPO> vehicles = new ArrayList<OrignalVehiclesPO>();
		List<AccountVO> accountvo=vo.getAccount();
		List<CommodityInVO> commodityvo=vo.getCommodity();
		List<OrganizationVO> organizationvo=vo.getOrganization();
		List<StaffVO> staffvo=vo.getStaff();
		List<VehicleVO> vehiclesvo=vo.getVehicles();
		for(int i=0;i<accountvo.size();i++){
			AccountVO v=accountvo.get(i);
			OrignalAccountPO po=new OrignalAccountPO(v.getAccountname(), v.getAccountsum(), v.getId());
			account.add(i, po);
		}
		for(int i=0;i<commodityvo.size();i++){
			CommodityInVO v=commodityvo.get(i);
			OrignalCommodityPO po=new OrignalCommodityPO(ocid.getid(), v.getOrdercode(), v.getIntime(), v.getLocation());
			commodity.add(i, po);
		}
		for(int i=0;i<organizationvo.size();i++){
			OrganizationVO v=organizationvo.get(i);
			OrignalOrganizationPO po=new OrignalOrganizationPO(ooid.getid(),v.getName(), v.getType());
			organization.add(i, po);
		}
		for(int i=0;i<staffvo.size();i++){
			StaffVO v=staffvo.get(i);
			OrignalStaffPO po=new OrignalStaffPO(osid.getid(), v.getName(), v.getJob());
			staff.add(i, po);
		}
		for(int i=0;i<vehiclesvo.size();i++){
			VehicleVO v=vehiclesvo.get(i);
			OrignalVehiclesPO po=new OrignalVehiclesPO(v.getVehiclecode(), v.getVehiclenum(), v.getExtendtime());
			vehicles.add(i, po);
		}
		this.newBook.setNewBook(id.getid(), time, account, commodity, organization, staff, vehicles);
		ResultMessage result=newBook.CreateNewBook();
		return result;
		
	}
}
