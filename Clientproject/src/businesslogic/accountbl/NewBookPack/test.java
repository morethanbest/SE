package businesslogic.accountbl.NewBookPack;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import po.CommodityLocation;
import po.Job;
import po.Organizationtype;
import vo.AccountVO;
import vo.CommodityInVO;
import vo.NewbookVO;
import vo.OrganizationVO;
import vo.ResultMessage;
import vo.StaffVO;
import vo.VehicleVO;
public class test {
	@Test
    public void testNewBook(){
		MockCreateNewBook createNewBook=new MockCreateNewBook();
		MockIdInfo idInfo=new MockIdInfo(1);
		MockOrignalComID ocid=new MockOrignalComID(1);
		MockOrignalOrganID ooid=new MockOrignalOrganID(1);
		MockOrignalStaffID osid=new MockOrignalStaffID(1);
		NewBook newBook=new NewBook(createNewBook, idInfo, ocid, ooid, osid);
		List<AccountVO> account = new ArrayList<AccountVO>();
		List<CommodityInVO> commodity = new ArrayList<CommodityInVO>();
		List<OrganizationVO> organization = new ArrayList<OrganizationVO>();
		List<StaffVO> staff = new ArrayList<StaffVO>();
		List<VehicleVO> vehicles = new ArrayList<VehicleVO>();
		AccountVO accountVO=new AccountVO(1, "song", 0);
		CommodityInVO commodityInVO=new CommodityInVO("1", 20151115, new CommodityLocation(0, 0, 0, 0));
		OrganizationVO organizationVO=new OrganizationVO("ss", Organizationtype.hall);
		StaffVO staffVO=new StaffVO("sc",Job.Courier);
		VehicleVO vehicleVO=new VehicleVO("100", "1", 12);
		account.add(accountVO);
		commodity.add(commodityInVO);
		organization.add(organizationVO);
		staff.add(staffVO);
		vehicles.add(vehicleVO);
		NewbookVO vo=new NewbookVO(1, account, commodity, organization, staff, vehicles); 
		ResultMessage result=newBook.CreateNewBook(vo);
		assertEquals(ResultMessage.success,result);
	}
}
