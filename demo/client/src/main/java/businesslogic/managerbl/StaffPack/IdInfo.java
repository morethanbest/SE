package businesslogic.managerbl.StaffPack;

import dataservice.managerdataservice.StaffDataService;
import init.RMIHelper;

public class IdInfo {
	long id;
	public long getid(){
		StaffDataService staff=RMIHelper.getStaffdata();
		try {
			this.id=staff.getLastId();
			this.id+=1;
			return this.id;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("getid fail");
			return 0;
		}
	}
}
