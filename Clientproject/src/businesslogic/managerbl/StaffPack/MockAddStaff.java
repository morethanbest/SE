package businesslogic.managerbl.StaffPack;

import po.Job;
import po.StaffPO;
import vo.ResultMessage;

public class MockAddStaff extends AddStaff {
	long id;
	String name;
	Job job;
	public void setAddInfo(long id,String name,Job job){
		this.id=id;
		this.name=name;
		this.job=job;
	}
	public ResultMessage addStaff(){
		StaffPO po=new StaffPO(id,name,job);
		ResultMessage result=ResultMessage.success;
		return result;
	}
}
