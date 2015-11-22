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
	
	public ResultMessage delete() throws RemoteException{
		OrganizationDataService organization=new OrganizationData();
		OrganizationPO po=organization.findOrganization(id);
		ResultMessage result=organization.deleteOrganization(po);
		return result;
		
	}
}
