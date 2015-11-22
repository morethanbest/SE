package presentation.enums;

public enum PackageTypes {
	Paper("纸箱"), Wood("木箱"), Plastic("快递袋"), Other("其他");
	
	private String name;

	private PackageTypes(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
