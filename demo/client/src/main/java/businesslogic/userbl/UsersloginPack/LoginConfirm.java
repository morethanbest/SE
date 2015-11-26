package businesslogic.userbl.UsersloginPack;

import dataservice.userdataservice.UserLoginDataService;
import init.RMIHelper;
import po.City;
import po.Job;
import po.Organizationtype;
import po.UserPO;
import vo.LoginVO;

public class LoginConfirm {
	String username;
	String password;
	public void setLogin(String username, String password){
		this.username=username;
		this.password=password;
	}
	public LoginVO log(){
		UserLoginDataService userdata=RMIHelper.getUserlogindata();
		LoginVO vo;
		try {
			UserPO po=userdata.login(username,password);
			if(po==null){
				vo=null;
			}
			else{
				String username=po.getUsername();
				Job job=po.getJob();
				String organizationname=po.getOrganizationname();
				String organizationcode=po.getOrganizationcode();
				Organizationtype organizationtype=po.getOrganizationtype();
				City city=po.getCity();
				vo=new LoginVO(username, job, organizationname, organizationcode, organizationtype, city);
			}

		} catch (Exception e) {
			System.out.println("Login fail");
			vo=null;
		}
		return vo;
	}

}
