package vo;

import po.Organizationtype;

public class OrganizationVO {
	String name;
	String organizationcode;
	Organizationtype type;
	String city;
	public OrganizationVO(String name, String organizationcode, Organizationtype type, String city) {
		this.name = name;
		this.organizationcode = organizationcode;
		this.type = type;
		this.city = city;
	}

	public String getName() {
		return name;
	}
	public String getOrganizationcode() {
		return organizationcode;
	}
	public Organizationtype getType() {
		return type;
	}
	public String getCity(){
		return city;
	}
	
}