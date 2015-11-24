package businesslogic.managerbl.StaffPack;

import dataservice.managerdataservice.StaffDataService;
import init.RMIHelper;
import po.Job;
import po.ResultMessage;
import po.StaffPO;

public class AddStaff {
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
		StaffDataService staff=RMIHelper.getStaffdata();
		ResultMessage result;
		try {
			result = staff.addStaff(po);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result=ResultMessage.failure;
			System.out.println("addstaff fail");
		}
		return result;
	}
}
