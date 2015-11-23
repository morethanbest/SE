package businesslogic.managerbl.StaffPack;

import po.Job;
import po.StaffPO;
import vo.ResultMessage;

public class MockDelStaff extends DelStaff {
	String name;
	Job job;
	public void setDelInfo(String name,Job job){
		this.job=job;
		this.name=name;
	}
	
	public ResultMessage delete(){
		StaffPO po=new StaffPO(5,name,job);		//以后为从数据层拿，再删去
		
		ResultMessage result=ResultMessage.success;
		return result;
		
	}
}
