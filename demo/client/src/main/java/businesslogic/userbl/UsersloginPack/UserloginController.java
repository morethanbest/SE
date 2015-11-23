package businesslogic.userbl.UsersloginPack;



import businesslogicservice.userblservice.UserloginBlService;
import vo.LoginVO;

public class UserloginController implements UserloginBlService{



	@Override
	public LoginVO login(long id, String password) {
		LoginConfirm con=new LoginConfirm();
		Userlogin login=new Userlogin(con);
		LoginVO vo=login.login(id,password);
		return vo;
	}
}
