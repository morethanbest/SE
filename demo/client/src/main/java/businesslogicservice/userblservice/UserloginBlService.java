package businesslogicservice.userblservice;

import vo.LoginVO;
public interface UserloginBlService {
	
	public LoginVO login(long id,String password);

}
