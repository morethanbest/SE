package businesslogic.managerbl;

import po.Organizationtype;

public class FindOrganization {
	
	public MockOrganization find(String name){
		Organizationtype type=Organizationtype.hall;
		MockOrganization o=new MockOrganization(1,name,type);
		return o;
	}
}
