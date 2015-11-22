package presentation.enums;

public enum OrderTypes {
	EMS("经济快递"), Standard("标准快递"), Express("特快");

	private String name;

	private OrderTypes(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
