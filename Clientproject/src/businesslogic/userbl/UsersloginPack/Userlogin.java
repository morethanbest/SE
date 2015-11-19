package businesslogic.userbl.UsersloginPack;

import vo.ResultMessage;

public class Userlogin {
	LoginConfirm con;
	public Userlogin(LoginConfirm con) {
		// TODO Auto-generated constructor stub
		this.con=con;
	}
	
	public ResultMessage login(long id, String password){
		ResultMessage result=con.log(id,password);
		return result;
	}

}
