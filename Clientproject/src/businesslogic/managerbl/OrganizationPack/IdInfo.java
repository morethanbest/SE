package businesslogic.managerbl.OrganizationPack;

import java.rmi.RemoteException;

import data.managerdata.OrganizationData;
import dataservice.managerdataservice.OrganizationDataService;


public class IdInfo {
	long id;
	public long getid(){
		OrganizationDataService organization=new OrganizationData();
		try {
			this.id=organization.getLastId();
			this.id+=1;
			return this.id;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return 0;
		}
	}
}
