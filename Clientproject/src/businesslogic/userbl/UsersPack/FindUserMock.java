package businesslogic.userbl.UsersPack;

import vo.UserVO;

public class FindUserMock {
	private UserVO vo;
	public FindUserMock(UserVO vo) {
		// TODO Auto-generated constructor stub
			this.vo=vo;
	}
	
	public UserVO getvo(){
		return vo;
	}

}
