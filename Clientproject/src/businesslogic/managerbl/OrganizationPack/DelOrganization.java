package businesslogic.managerbl.OrganizationPack;

import java.rmi.RemoteException;

import data.managerdata.OrganizationData;
import dataservice.managerdataservice.OrganizationDataService;
import po.OrganizationPO;
import po.Organizationtype;
import vo.ResultMessage;

public class DelOrganization {
	long id;
	public void setDelInfo(long id){
		this.id=id;
	}
	
	public ResultMessage delete(){
		OrganizationDataService organization=new OrganizationData();
		OrganizationPO po;
		ResultMessage result;
		try {
			po = organization.findOrganization(id);
			result=organization.deleteOrganization(po);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result=ResultMessage.failure;
			System.out.println("delete fail");
		}
		return result;
		
	}
}
