package businesslogic.userbl.UsersPack;

import po.UserPO;
import vo.ResultMessage;

public class DelUser {

	public ResultMessage deluser(){
		UserPO po=new UserPO(id,username,password,level);
		ResultMessage result=ResultMessage.success;
		return result;
	}

}
