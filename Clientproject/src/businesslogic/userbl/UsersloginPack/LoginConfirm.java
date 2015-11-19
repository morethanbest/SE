package businesslogic.userbl.UsersloginPack;

import java.rmi.RemoteException;

import vo.ResultMessage;
import data.datafactory.databaseFactory;
import data.userdata.UserLoginData;

public class LoginConfirm {

	public ResultMessage log(long id, String password){
		databaseFactory fac=new databaseFactory();
		UserLoginData userdata=fac.getUserLogin();
		ResultMessage result=ResultMessage.failure;
		try {
			result=userdata.login(id,password);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("RemoteException!!");
			e.printStackTrace();
		}
		return result;
	}

}
