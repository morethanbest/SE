package businesslogic.userbl.UsersloginPack;

import java.rmi.RemoteException;

import data.datafactory.databaseFactory;
import data.userdata.UserLoginData;
import po.Job;
import po.LoginPO;
import vo.LoginVO;

public class LoginConfirm {

	public LoginVO log(long id, String password){
		databaseFactory fac=new databaseFactory();
		UserLoginData userdata=fac.getUserLogin();
	
		try {
			LoginPO po=userdata.login(id, password);
			LoginVO vo=new LoginVO(po.getUsername(),po.getHall(),po.getJob());
			return vo;
		} catch (RemoteException e) {
			return new LoginVO(null,null,Job.visitor);
		}
		
	}

}
