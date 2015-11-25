package presentation.enums;

import po.Organizationtype;

public enum OrganizationType {
	Hall("营业厅",Organizationtype.hall), Center("中转中心", Organizationtype.transfercenter);
	private String name;
	private Organizationtype org;
	private OrganizationType(String name, Organizationtype org) {
		this.name = name;
		this.org = org;
	}

	public String getName() {
		return name;
	}

	public Organizationtype getOrg() {
		return org;
	}
	
	
}
