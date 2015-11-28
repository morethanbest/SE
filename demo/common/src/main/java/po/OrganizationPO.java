package po;

import java.io.Serializable;

public class OrganizationPO  implements Serializable{
	String name;
	String organizationcode;
	Organizationtype type;
	String city;
	public OrganizationPO(String name, String organizationcode, Organizationtype type, String city) {
		this.name = name;
		this.organizationcode = organizationcode;
		this.type = type;
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrganizationcode() {
		return organizationcode;
	}
	public void setOrganizationcode(String organizationcode) {
		this.organizationcode = organizationcode;
	}
	public Organizationtype getType() {
		return type;
	}
	public void setType(Organizationtype type) {
		this.type = type;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
