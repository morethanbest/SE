package businesslogic.userbl.UsersloginPack.Mock;

import vo.ResultMessage;

public class LoginConfirmMock {
	public ResultMessage log(long id, String password){
		return ResultMessage.success;
	}


}
