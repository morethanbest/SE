package businesslogic.managerbl.StaffPack;

import dataservice.managerdataservice.StaffDataService;
import init.RMIHelper;
import po.*;

public class AddStaff {
	long id;
	String name;
	Job job;
	String organizationname;
	String organizationcode;
	Organizationtype organizationtype;
	City city;
	public void setAddInfo(long id, String name, Job job, String organizationname, String organizationcode,
						   Organizationtype type, City city){
		this.id=id;
		this.name=name;
		this.job=job;
		this.organizationname=organizationname;
		this.organizationcode=organizationcode;
		this.organizationtype=organizationtype;
		this.city=city;
	}
	public ResultMessage addStaff(){
		StaffPO po=new StaffPO(id, name, job, organizationname, organizationcode, organizationtype, city);
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
