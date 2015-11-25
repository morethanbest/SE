package presentation.enums;

public enum OrganizationType {
	Hall("营业厅"), Center("中转中心");
	private String name;

	private OrganizationType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
