
public class OrignalOrganizationPO {
	long id;
	String name;
	Organization type;
	public OrignalOrganizationPO(long id, String name, Organization type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Organization getType() {
		return type;
	}
	
}
