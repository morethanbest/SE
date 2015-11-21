package po;

public class OrignalOrganizationPO {
	long id;
	String name;
	Organizationtype type;
	public OrignalOrganizationPO(long id, String name, Organizationtype type) {
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
	public Organizationtype getType() {
		return type;
	}
	
}
