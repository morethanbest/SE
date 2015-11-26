package businesslogic.userbl.UsersPack;

import po.City;
import po.Job;
import po.Organizationtype;
import po.ResultMessage;
import vo.UserVO;

public class User {
	private AddUser add;
	private DelUser del;
	private RevUser rev;
	private FindUser find;
	
	public User(AddUser add) {
		// TODO Auto-generated constructor stub
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
	
	
	
	
	public ResultMessage addUser(UserVO vo){ 
		// TODO Auto-generated method stub
		String username=vo.getUsername();
		String password=vo.getPassword();
		Job job=vo.getJob();
		String organizationname=vo.getOrganizationname();
		String organizationcode=vo.getOrganizationcode();
		Organizationtype organizationtype=vo.getOrganizationtype();
		City city=vo.getCity();
		add.setAddInfo(username, password, job, organizationname, organizationcode, organizationtype, city);
		ResultMessage result=add.adduser();
		return result;
		
		
	}

	
	public ResultMessage delUser(UserVO vo) {
		// TODO Auto-generated method stub
		String username=vo.getUsername();
		String password=vo.getPassword();
		Job job=vo.getJob();
		String organizationname=vo.getOrganizationname();
		String organizationcode=vo.getOrganizationcode();
		Organizationtype organizationtype=vo.getOrganizationtype();
		City city=vo.getCity();
		del.setDelInfo(username, password, job, organizationname, organizationcode, organizationtype, city);
		ResultMessage result=del.deluser();
		return result;
	}

	
	public ResultMessage revUser(UserVO vo){
		// TODO Auto-generated method stub
		String username=vo.getUsername();
		String password=vo.getPassword();
		Job job=vo.getJob();
		String organizationname=vo.getOrganizationname();
		String organizationcode=vo.getOrganizationcode();
		Organizationtype organizationtype=vo.getOrganizationtype();
		City city=vo.getCity();
		rev.setRevInfo(username, password, job, organizationname, organizationcode, organizationtype, city);
		ResultMessage result=rev.revuser();
		return result;
	}

	
	public UserVO getUserbyName(String username) {
		// TODO Auto-generated method stub
		find.setFindInfo(username);
		UserVO vo=find.getvo();
		return vo;
	}
	
	
}
