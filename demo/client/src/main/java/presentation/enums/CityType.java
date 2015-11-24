package presentation.enums;

public enum CityType {
	Beijing("北京"), Shanghai("上海"), Guangzhou("广州"), Nanjing("南京");

	private String name;

	private CityType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
