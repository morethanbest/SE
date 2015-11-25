package vo;

import po.City;
import po.Organizationtype;

public class OrganizationVO {
	String name;
	String organizationcode;
	Organizationtype type;
	City city;
	public OrganizationVO(String name, String organizationcode, Organizationtype type, City city) {
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
	public City getCity(){
		return city;
	}
	
}