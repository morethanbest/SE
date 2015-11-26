package businesslogicservice.userblservice;

import vo.LoginVO;
public interface UserloginBlService {
	
	public LoginVO login(String username,String password);

}
