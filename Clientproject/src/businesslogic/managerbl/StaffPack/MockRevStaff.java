package businesslogic.managerbl.StaffPack;

import po.Job;
import po.StaffPO;
import vo.ResultMessage;

public class MockRevStaff extends RevStaff {
	String name;
	Job job;
	public void setRevInfo(String name,Job job){
		this.job=job;
		this.name=name;
	}
	
	public ResultMessage rev(){
		StaffPO po=new StaffPO(5,name,job);		//以后为从数据层拿，再删去
		long id=po.getId();
		StaffPO newpo=new StaffPO(id,name,job);
		ResultMessage result=ResultMessage.success;
		return result;
		
	}
}
