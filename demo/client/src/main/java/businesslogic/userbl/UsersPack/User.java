package businesslogic.userbl.UsersPack;

import java.rmi.RemoteException;

import vo.ResultMessage;
import vo.UserVO;

public class User {
	private IdInfo idgetter;
	private AddUser add;
	private DelUser del;
	private RevUser rev;
	private FindUser find;
	
	public User(AddUser add,IdInfo idgetter) {
		// TODO Auto-generated constructor stub
		this.idgetter=idgetter;
		this.add=add;
	}
	
	public User(DelUser del){
		this.del=del;
	}
	
	public User(RevUser rev){
		this.rev=rev;
	}
	public User(FindUser find){
		this.find=find;
	}
	
	
	
	
	public ResultMessage addUser(UserVO vo) throws RemoteException {                              //revise
		// TODO Auto-generated method stub
		String username=vo.getUsername();
		String password=vo.getCode();
		String level=vo.getLevel();
		long id=idgetter.getid();
		
		//add.setUser(id, username, password, level);
		ResultMessage result=add.adduser(username,password,level,id);
		return result;
		
		
	}

	
	public ResultMessage delUser(UserVO vo,long id) throws RemoteException {
		// TODO Auto-generated method stub
		String username=vo.getUsername();
		String password=vo.getCode();
		String level=vo.getLevel();
		long toid=id;
		
		del.setUser(toid, username, password, level);
		ResultMessage result=del.deluser();
		return result;
	}

	
	public ResultMessage revUser(UserVO vo,long id) throws RemoteException {
		// TODO Auto-generated method stub
		String username=vo.getUsername();
		String password=vo.getCode();
		String level=vo.getLevel();
		long toid=id;
		
		rev.setUser(toid, username, password, level);
		ResultMessage result=rev.revuser();
		return result;
	}

	
	public UserVO getUserbyID(long id) throws RemoteException {
		// TODO Auto-generated method stub
		UserVO vo=find.getvo();
		return vo;
	}
	
	
}
