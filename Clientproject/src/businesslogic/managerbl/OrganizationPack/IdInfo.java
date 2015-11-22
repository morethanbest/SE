package businesslogic.managerbl.OrganizationPack;

import java.rmi.RemoteException;

import data.managerdata.OrganizationData;
import dataservice.managerdataservice.OrganizationDataService;


public class IdInfo {
	long id;
	public long getid() throws RemoteException{
		OrganizationDataService organization=new OrganizationData();
		this.id=organization.getLastId();
		this.id+=1;
		return this.id;
	}
}
