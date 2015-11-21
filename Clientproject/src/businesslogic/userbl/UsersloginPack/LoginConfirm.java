package businesslogic.userbl.UsersloginPack;

import java.rmi.RemoteException;

import RMI.FactoryGet;
import data.datafactory.databaseFactory;
import data.userdata.UserLoginData;
import po.Job;

public class LoginConfirm {

	public Job log(long id, String password){
		databaseFactory fac=FactoryGet.getfactory();
		UserLoginData userdata=fac.getUserLogin();
		try {
			return userdata.login(id,password);
		} catch (RemoteException e) {
			return Job.visitor;
		}
		
	}

}
