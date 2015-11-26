package businesslogic.userbl.UsersloginPack;

import init.RMIHelper;

import java.rmi.RemoteException;

import po.City;
import po.Job;
import po.Organizationtype;
import po.UserPO;
import vo.LoginVO;
import dataservice.userdataservice.UserLoginDataService;

public class LoginConfirm {
	long id;
	String password;
	public void setLogin(long id, String password){
		this.id=id;
		this.password=password;
	}
	public LoginVO log(){
		UserLoginDataService userdata=RMIHelper.getUserlogindata();
		LoginVO vo;
		try {
			UserPO po=userdata.login(id,password);
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
