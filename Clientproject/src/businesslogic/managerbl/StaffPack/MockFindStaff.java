package businesslogic.managerbl.StaffPack;

import po.Job;
import po.StaffPO;
import vo.StaffVO;

public class MockFindStaff extends FindStaff{
	String name;
	
	public void setFindInfo(String name){
		this.name=name;
	}
	public StaffVO findStaff(){
		StaffPO po=new StaffPO(5,name,Job.Courier);		//以后为从数据层拿
		Job job=po.getJob();
		String name=po.getName();
		StaffVO vo=new StaffVO(name,job);
		return vo;
	}
}
