package businesslogic.userbl.UsersloginPack;

import init.RMIHelper;

import java.rmi.RemoteException;

import po.Job;
import po.LoginPO;
import vo.LoginVO;
import dataservice.userdataservice.UserLoginDataService;

public class LoginConfirm {

	public LoginVO log(long id, String password){
//		databaseFactory fac=FactoryGet.getfactory();
//		UserLoginData userdata=fac.getUserLogin();
		UserLoginDataService userdata=RMIHelper.getUserlogindata();
		try {
			LoginPO po=userdata.login(id,password);
			
			return new LoginVO(po.getUsername(),po.getHall(),po.getJob());
		} catch (RemoteException e) {
			return new LoginVO(null,null,Job.visitor);
		}
		
	}

}
