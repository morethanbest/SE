package businesslogic.userbl.UsersPack;

import dataservice.userdataservice.UserDataService;
import init.RMIHelper;
import po.Job;
import po.Organizationtype;
import po.UserPO;
import vo.UserVO;

public class FindUser {
	String username;
	public void setFindInfo(String username){
		this.username=username;
	}
	public UserVO getvo(){
		UserDataService user=RMIHelper.getUserdata();
		UserPO po;
		UserVO vo;
		try {
			po=user.find(username);
			String username=po.getUsername();
			String password=po.getPassword();
			Job job=po.getJob();
			String organizationname=po.getOrganizationname();
			String organizationcode=po.getOrganizationcode();
			Organizationtype organizationtype=po.getOrganizationtype();
			String city=po.getCity();
			vo=new UserVO(username, password, job, organizationname, organizationcode, organizationtype, city);
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("finduser fail");
			vo=null;
		}
		return vo;
	}

}
