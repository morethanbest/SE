package businesslogic.managerbl;

import po.Organizationtype;

public class AddOrganization {
	public AddOrganization(){
		
	}
	
	public long addOrganization(String name,Organizationtype type){
		long id=1;
		MockOrganization o=new MockOrganization(id,name,type);
		return id;
	}
}
