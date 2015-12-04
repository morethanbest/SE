package businesslogicservice.userblservice;

import po.ResultMessage;
import vo.OrganizationVO;
import vo.UserVO;

public interface UserBlService {
	
	
	public ResultMessage addUser(UserVO vo);
	
	public ResultMessage delUser(UserVO vo);
	
	public ResultMessage revUser(UserVO vo);
	
	public UserVO getUserbyName(String username);
	
	public OrganizationVO findOrgByCode(String orgcode);

}
