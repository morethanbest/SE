package businesslogic.managerbl.StaffPack;

import java.rmi.RemoteException;

import data.managerdata.StaffData;
import dataservice.managerdataservice.StaffDataService;

public class IdInfo {
	long id;
	public long getid() throws RemoteException{
		StaffDataService staff=new StaffData();
		this.id=staff.getLastId();
		this.id+=1;
		return this.id;
	}
}
