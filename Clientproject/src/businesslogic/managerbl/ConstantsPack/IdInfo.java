package businesslogic.managerbl.ConstantsPack;

import java.rmi.RemoteException;

import data.managerdata.ConstantsData;
import dataservice.managerdataservice.ConstantsDataService;

public class IdInfo {
	long id;
	public long getid(){
		ConstantsDataService constants=new ConstantsData();
		try {
			this.id=constants.getLastId();
			this.id+=1;
			return this.id;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("getis fail");
			return 0;
		}
	}
}
