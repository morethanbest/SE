package businesslogic.managerbl.OrganizationPack;

import java.rmi.RemoteException;

import data.managerdata.OrganizationData;
import dataservice.managerdataservice.OrganizationDataService;
import po.OrganizationPO;
import po.Organizationtype;
import vo.ResultMessage;

public class AddOrganization {
	long id;
	String name;
	Organizationtype type;
	
	public void setAddInfo(long id,String name,Organizationtype type){
		this.id=id;
		this.name=name;
		this.type=type;
	}
	
	
	public ResultMessage addOrganization(){
		OrganizationDataService organization=new OrganizationData();
		OrganizationPO po=new OrganizationPO(id,name,type);
		ResultMessage result;
		try {
			result = organization.addOrganization(po);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result = ResultMessage.failure;
			System.out.println("addorganization fail");
		}
		return result;
	}
}
