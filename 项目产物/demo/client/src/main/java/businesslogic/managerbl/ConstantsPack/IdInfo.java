package businesslogic.managerbl.ConstantsPack;

import dataservice.managerdataservice.ConstantsDataService;
import init.RMIHelper;

public class IdInfo {
	long id;
	public long getid(){
		ConstantsDataService constants=RMIHelper.getConstantsdata();
		try {
			this.id=constants.getLastId();
			this.id+=1;
			return this.id;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("getis fail");
			return 0;
		}
	}
}
