package businesslogic.userbl.UsersPack;

import dataservice.userdataservice.UserDataService;
import init.RMIHelper;
import po.Job;
import po.Organizationtype;
import po.ResultMessage;
import po.UserPO;

public class AddUser {
	String username;
	String password;
	Job job;
	String organizationname;
	String organizationcode;
	Organizationtype organizationtype;
	String city;
    public void setAddInfo(String username, String password, Job job, String organizationname, String organizationcode,
			Organizationtype organizationtype, String city){
		this.username = username;
		this.password = password;
		this.job = job;
		this.organizationname = organizationname;
		this.organizationcode = organizationcode;
		this.organizationtype = organizationtype;
		this.city = city;
    }
	public ResultMessage adduser(){
		UserPO po=new UserPO(username, password, job, organizationname, organizationcode, organizationtype, city);
		UserDataService user=RMIHelper.getUserdata();
		ResultMessage result;
		try {
			result = user.add(po);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result=ResultMessage.failure;
			System.out.println("adduser fail");
		}
		return result;
	}

}
