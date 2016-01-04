package businesslogic.userbl.UsersloginPack;

import vo.LoginVO;

public class Userlogin {
	LoginConfirm con;
	public Userlogin(LoginConfirm con) {
		// TODO Auto-generated constructor stub
		this.con=con;
	}
	
	public LoginVO login(String username, String password) {
		con.setLogin(username, password);
		LoginVO vo=con.log();
		return vo;
	}

}
