package businesslogic.userbl.UsersPack;

import java.rmi.RemoteException;

import vo.ResultMessage;
import vo.UserVO;

public class User {
	private IdInfoMock idgetter;
	private AddUserMock add;
	private DelUserMock del;
	private RevUserMock rev;
	private FindUserMock find;
	
	public User(AddUserMock add,IdInfoMock idgetter) {
		// TODO Auto-generated constructor stub
		this.idgetter=idgetter;
		this.add=add;
	}
	
	public User(DelUserMock del){
		this.del=del;
	}
	
	public User(RevUserMock rev){
		this.rev=rev;
	}
	public User(FindUserMock find){
		this.find=find;
	}
	
	
	
	
	public ResultMessage addUser(UserVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		String username=vo.getUsername();
		String password=vo.getCode();
		String level=vo.getLevel();
		long id=idgetter.getid();
		
		add.setUser(id, username, password, level);
		ResultMessage result=add.adduser();
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
