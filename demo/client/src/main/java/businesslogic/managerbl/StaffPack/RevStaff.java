package businesslogic.managerbl.StaffPack;

import dataservice.managerdataservice.StaffDataService;
import init.RMIHelper;
import po.Job;
import po.ResultMessage;
import po.StaffPO;

public class RevStaff {
	long id;
	String name;
	Job job;
	public void setRevInfo(Long id, String name,Job job){
		this.id=id;
		this.job=job;
		this.name=name;
	}
	
	public ResultMessage rev(){
		StaffDataService staff=RMIHelper.getStaffdata();
		StaffPO po=new StaffPO(id, name, job);
		ResultMessage result;
		try {
			result = staff.updateStaff(po);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("revstaff fail");
			result=ResultMessage.failure;
		}
		return result;
		
	}
}
