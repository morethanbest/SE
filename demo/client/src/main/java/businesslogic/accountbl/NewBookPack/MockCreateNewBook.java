package businesslogic.accountbl.NewBookPack;

import java.util.List;

import po.NewbookPO;
import po.OrignalAccountPO;
import po.OrignalCommodityPO;
import po.OrignalOrganizationPO;
import po.OrignalStaffPO;
import po.OrignalVehiclesPO;
import vo.NewbookVO;
import vo.ResultMessage;

public class MockCreateNewBook extends CreateNewBook{
	long id;
	long time;
	List<OrignalAccountPO> account;
	List<OrignalCommodityPO> commodity;
	List<OrignalOrganizationPO> organization;
	List<OrignalStaffPO> staff;
	List<OrignalVehiclesPO> vehicles;
	public void setNewBook(long id, long time,List<OrignalAccountPO> account,List<OrignalCommodityPO> commodity,
			List<OrignalOrganizationPO> organization,List<OrignalStaffPO> staff,List<OrignalVehiclesPO> vehicles){
		this.id=id;
		this.time=time;
		this.account=account;
		this.commodity=commodity;
		this.organization=organization;
		this.staff=staff;
		this.vehicles=vehicles;
	}
	public ResultMessage CreateNewBook(){
		NewbookPO po=new NewbookPO(id, account, commodity, organization, staff, vehicles);
		ResultMessage result=ResultMessage.success;
		return result;
		
	}
}
