package presentation.enums;

public enum TransportTypes {
	Bus("汽车"), Train("火车"), Air("飞机");

	private String name;

	private TransportTypes(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
