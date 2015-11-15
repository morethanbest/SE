package vo;

import po.Organizationtype;

public class OrganizationVO {
	String name;
	Organizationtype type;
	public OrganizationVO( String name, Organizationtype type) {
		this.name = name;
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public Organizationtype getType() {
		return type;
	}
	
}