package Bldriver;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.UserBlService;
import vo.ResultMessage;
import vo.UserVO;

public class User_Driver {
	public void driver(UserBlService userBlservice){
		try{
			ResultMessage result=userBlservice.addUser(new UserVO(1,"1","1","1"));
			if(result==ResultMessage.success)
				System.out.println("User added");
			result=userBlservice.delUser(new UserVO(1,"1","1","1"));
			if(result==ResultMessage.success)
				System.out.println("User deleted");
			result=userBlservice.login(1, "11");
			if(result==ResultMessage.success)
				System.out.println("Login successfully");
			result=userBlservice.revUser(new UserVO(1,"1","1","1"));
			if(userBlservice.getUserbyID(1)!=null){
				System.out.println("User get");
			}
		}catch(RemoteException e){
			e.printStackTrace();
		}
	}
}
