package businesslogic.managerbl.OrganizationPack;

import java.rmi.RemoteException;

import data.managerdata.OrganizationData;
import dataservice.managerdataservice.OrganizationDataService;
import po.OrganizationPO;
import po.Organizationtype;
import vo.ResultMessage;

public class RevOrganization {
	long id;
	String name;
	Organizationtype type;
	public void setRevInfo(Long id, String name,Organizationtype type){
		this.id=id;
		this.type=type;
		this.name=name;
	}
	
	public ResultMessage rev() throws RemoteException{
		OrganizationDataService organization=new OrganizationData();
		OrganizationPO newpo=new OrganizationPO(id,name,type);
		ResultMessage result=organization.updateOrganization(newpo);
		return result;
		
	}
}
