package businesslogic.userbl.UsersloginPack;

import vo.ResultMessage;
import data.datafactory.databaseFactory;
import data.userdata.UserLoginData;

public class LoginConfirm {

	public ResultMessage log(long id, String password){
		databaseFactory fac=new databaseFactory();
		UserLoginData userdata=fac.getUserLogin();
		String idstr=Long.toString(id);
		ResultMessage result=userdata.login(idstr,password);
		return ResultMessage.success;
	}

}
