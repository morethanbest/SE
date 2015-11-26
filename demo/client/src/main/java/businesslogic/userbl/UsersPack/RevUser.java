package businesslogic.userbl.UsersPack;

import po.UserPO;
import dataservice.userdataservice.UserDataService;
import init.RMIHelper;
import po.City;
import po.Job;
import po.Organizationtype;
import po.ResultMessage;

public class RevUser {
	String username;
	String password;
	Job job;
	String organizationname;
	String organizationcode;
	Organizationtype organizationtype;
	City city;
    public void setRevInfo(String username, String password, Job job, String organizationname, String organizationcode,
			Organizationtype organizationtype, City city){
		this.username = username;
		this.password = password;
		this.job = job;
		this.organizationname = organizationname;
		this.organizationcode = organizationcode;
		this.organizationtype = organizationtype;
		this.city = city;
    }
	public ResultMessage revuser(){
		UserPO po=new UserPO(username, password, job, organizationname, organizationcode, organizationtype, city);
		UserDataService user=RMIHelper.getUserdata();
		ResultMessage result;
		try {
			result = user.update(po);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result=ResultMessage.failure;
			System.out.println("revuser fail");
		}
		return result;
	}

}
