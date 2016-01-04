package businesslogic.userbl.inlinepack;

import java.rmi.RemoteException;

import init.RMIHelper;
import po.Job;
import po.Organizationtype;
import po.ResultMessage;
import po.UserPO;
import businesslogicservice.userblservice.Inline;
import dataservice.userdataservice.UserDataService;

public class Inlinetest implements Inline{



	@Override
	public ResultMessage addNew() throws RemoteException {
		// TODO Auto-generated method stub
		UserPO po=new UserPO("adf","fadfa",Job.drivers,"FDAFF","FDAFA",Organizationtype.hall,"fadfa");
		UserDataService user=RMIHelper.getUserdata();
		ResultMessage result=null;
		result=user.testline(po);
		return result;
		
	}

}
