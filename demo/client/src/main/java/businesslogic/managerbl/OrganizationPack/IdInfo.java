package businesslogic.managerbl.OrganizationPack;

import dataservice.managerdataservice.OrganizationDataService;
import init.RMIHelper;


public class IdInfo {
	long id;
	public long getid(){
		OrganizationDataService organization=RMIHelper.getOrgdata();
		try {
			this.id=organization.getLastId();
			this.id+=1;
			return this.id;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return 0;
		}
	}
}
