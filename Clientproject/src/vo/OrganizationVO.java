package vo;

import po.Organizationtype;

public class OrganizationVO {
	long id;
	String name;
	Organizationtype type;
	public OrganizationVO(Long id, String name, Organizationtype type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}
	public long getId(){
		return id;
	}
	public String getName() {
		return name;
	}
	public Organizationtype getType() {
		return type;
	}
	
}