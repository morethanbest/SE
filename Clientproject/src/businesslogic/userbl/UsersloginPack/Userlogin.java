package businesslogic.userbl.UsersloginPack;

import vo.ResultMessage;

public class Userlogin {
	LoginConfirmMock con;
	public Userlogin(LoginConfirmMock con) {
		// TODO Auto-generated constructor stub
		this.con=con;
	}
	
	public ResultMessage login(){
		ResultMessage result=con.log();
		return result;
	}

}
