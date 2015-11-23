package businesslogic.managerbl.StaffPack;

import java.rmi.RemoteException;

import data.managerdata.StaffData;
import dataservice.managerdataservice.StaffDataService;

public class IdInfo {
	long id;
	public long getid(){
		StaffDataService staff=new StaffData();
		try {
			this.id=staff.getLastId();
			this.id+=1;
			return this.id;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("getid fail");
			return 0;
		}
	}
}
