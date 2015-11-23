package businesslogic.userbl.UsersloginPack;

import vo.LoginVO;

public class Userlogin {
	LoginConfirm con;
	public Userlogin(LoginConfirm con) {
		// TODO Auto-generated constructor stub
		this.con=con;
	}
	
	public LoginVO login(long id, String password) {
		LoginVO login=con.log(id,password);
		return login;
	}

}
