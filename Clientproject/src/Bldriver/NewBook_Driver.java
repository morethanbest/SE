package Bldriver;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import businesslogic.accountbl.stub.NewBookBLService_Stub;
import businesslogicservice.accountblservice.NewBookBlService;
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

public class NewBook_Driver {
	public void driver(NewBookBlService NewBookBlservice){
		try{
			List<AccountVO> l1=new ArrayList<AccountVO>();
			l1.add(new AccountVO(1,"abc",100));
			List<CommodityInVO> l2=new ArrayList<CommodityInVO>();
			l2.add(new CommodityInVO("a",1,new CommodityLocation(1,1,1,1)));
			List<OrganizationVO> l3=new ArrayList<OrganizationVO>();
			l3.add(new OrganizationVO("1",Organizationtype.hall));
			List<VehicleVO> l4=new ArrayList<VehicleVO>();
			l4.add(new VehicleVO("1","1",1));
			List<StaffVO> l5=new ArrayList<StaffVO>();
			l5.add(new StaffVO("1",Job.Courier));
			ResultMessage result=NewBookBlservice.NewBook(new NewbookVO(1,l1,l2,l3,l5,l4));
			if(result==ResultMessage.success)
				System.out.println("NewBook added");
		}catch(RemoteException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		NewBookBlService NewBookBlservice=new NewBookBLService_Stub();
		NewBook_Driver driver=new NewBook_Driver();
		driver.driver(NewBookBlservice);
	}
}
