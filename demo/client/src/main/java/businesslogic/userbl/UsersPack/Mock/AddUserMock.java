package businesslogic.userbl.UsersPack.Mock;

import po.UserPO;
import vo.ResultMessage;

public class AddUserMock {
	long id;
	String username;
	String password;
	String level;
	
	
	
	public void setUser(long id,String username,String password,String level) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.username=username;
		this.password=password;
		this.level=level;
		
	}
	
	
	
	
	public ResultMessage adduser(){
		UserPO po=new UserPO(id,username,password,level);
		ResultMessage result=ResultMessage.success;
		return result;
	}
	
	
	
	
	

}
