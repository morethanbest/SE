package businesslogic.userbl.UsersPack;

import po.UserPO;
import vo.ResultMessage;
import data.datafactory.databaseFactory;
import data.userdata.UsersData;
import dataservice.datafactoryservice.datafactoryserv;

public class AddUser {

	public ResultMessage adduser(String username,String password,String level,long id){
		UserPO po=new UserPO(id,username,password,level);
		databaseFactory fac=new databaseFactory();
		UsersData userdata=fac.getUsersData();
		ResultMessage result=fac.UsersData.;
		
		
		
		
		return result;
	}

}
