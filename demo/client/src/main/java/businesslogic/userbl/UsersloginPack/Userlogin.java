package businesslogic.userbl.UsersloginPack;

import vo.LoginVO;

public class Userlogin {
	LoginConfirm con;
	public Userlogin(LoginConfirm con) {
		// TODO Auto-generated constructor stub
		this.con=con;
	}
	
	public LoginVO login(long id, String password) {
		con.setLogin(id, password);
		LoginVO vo=con.log();
		return vo;
	}

}
