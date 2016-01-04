package presentation.enums;

public enum ContstantType {
	Distance("距离"),City("城市"),PackageType("包装类型"),OrderType("快递类型"),TransportType("运输类型");
	
	private String name;

	private ContstantType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
