package po;

import java.io.Serializable;

public class OrganizationPO  implements Serializable{
	long id;
	String name;
	Organizationtype type;
	public OrganizationPO(long id,String name, Organizationtype type) {
		this.id=id;
		this.name = name;
		this.type = type;
	}
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Organizationtype getType() {
		return type;
	}
	public void setType(Organizationtype type) {
		this.type = type;
	}
	
}
