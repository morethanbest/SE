package businesslogic.managerbl;

import po.Organizationtype;
import po.OrganizationPO;

public class MockOrganization extends OrganizationPO {
	public MockOrganization(long id,String name, Organizationtype type){
		super(id,name,type);
	}
}
