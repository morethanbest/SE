import java.io.Serializable;

public class OrganizationPO  implements Serializable{
	long id;
	String name;
	Organization type;
	public OrganizationPO(long id,String name, Organization type) {
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
	public Organization getType() {
		return type;
	}
	public void setType(Organization type) {
		this.type = type;
	}
	
}
