package Bldriver;

import java.rmi.RemoteException;

import businesslogic.managerbl.stub.OrganizationBlService_Stub;
import businesslogicservice.managerblservice.OrganizationBlService;
import po.Organizationtype;
import vo.OrganizationVO;
import vo.ResultMessage;

public class Organization_Driver {
	public void driver(OrganizationBlService organizationBlservice){
		try{
			ResultMessage result=organizationBlservice.addOrganization(new OrganizationVO("1",Organizationtype.hall));
			if(result==ResultMessage.success)
				System.out.println("Organization added");
			result=organizationBlservice.delOrganization(new OrganizationVO("1",Organizationtype.hall));
			if(result==ResultMessage.success)
				System.out.println("Organization deleted");
			result=organizationBlservice.revOrganization(new OrganizationVO("1",Organizationtype.hall));
			if(result==ResultMessage.success)
				System.out.println("Organization successfully");
			if(organizationBlservice.getOrganization("a")!=null){
				System.out.println("Organization get");
			}
		}catch(RemoteException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		OrganizationBlService organizationBlservice=new OrganizationBlService_Stub();
		Organization_Driver driver=new Organization_Driver();
		driver.driver(organizationBlservice);
	}
}
