package businesslogic.managerbl.StaffPack;

import dataservice.managerdataservice.StaffDataService;
import init.RMIHelper;
import po.*;

public class RevStaff {
	long id;
	String name;
	Job job;
	String organizationname;
	String organizationcode;
	Organizationtype organizationtype;
	String city;
	public void setRevInfo(long id, String name, Job job, String organizationname, String organizationcode,
						   Organizationtype organizationtype, String city){
		this.id=id;
		this.name=name;
		this.job=job;
		this.organizationname=organizationname;
		this.organizationcode=organizationcode;
		this.organizationtype=organizationtype;
		this.city=city;
	}
	
	public ResultMessage rev(){
		StaffDataService staff=RMIHelper.getStaffdata();
		StaffPO po=new StaffPO(id, name, job, organizationname, organizationcode, organizationtype, city);
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
