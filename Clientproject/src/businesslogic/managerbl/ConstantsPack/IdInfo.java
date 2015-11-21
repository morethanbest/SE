package businesslogic.managerbl.ConstantsPack;

import java.rmi.RemoteException;

import data.managerdata.ConstantsData;
import dataservice.managerdataservice.ConstantsDataService;

public class IdInfo {
	long id;
	public long getid() throws RemoteException{
		ConstantsDataService constants=new ConstantsData();
		this.id=constants.getLastId();
		this.id+=1;
		return this.id;
	}
}
