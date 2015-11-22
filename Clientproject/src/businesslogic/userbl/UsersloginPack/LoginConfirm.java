package businesslogic.userbl.UsersloginPack;

import java.rmi.RemoteException;

import data.userdata.UserLoginData;
import dataservice.userdataservice.UserLoginDataService;
import po.Job;
import po.LoginPO;
import vo.LoginVO;

public class LoginConfirm {

	public LoginVO log(long id, String password){
//		databaseFactory fac=FactoryGet.getfactory();
//		UserLoginData userdata=fac.getUserLogin();
		UserLoginDataService userdata=new UserLoginData();
		try {
			LoginPO po=userdata.login(id,password);
			
			return new LoginVO(po.getUsername(),po.getHall(),po.getJob());
		} catch (RemoteException e) {
			return new LoginVO(null,null,Job.visitor);
		}
		
	}

}
