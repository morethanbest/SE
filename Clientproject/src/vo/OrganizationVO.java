package vo;

import po.Organization;

public class OrganizationVO {
	String name;
	Organization type;
	public OrganizationVO( String name, Organization type) {
		this.name = name;
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public Organization getType() {
		return type;
	}
	
}