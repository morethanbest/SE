package presentation.enums;

import po.City;

public enum CityType {
	Beijing("北京", City.Beijing), Shanghai("上海", City.Shanghai), Guangzhou("广州", City.Guangzhou), Nanjing("南京", City.Nanjing);

	private String name;
	private City city;
	private CityType(String name, City city) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public City getCity() {
		return city;
	}

}
