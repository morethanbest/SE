package po;

public enum TransportType {
	car("汽车"),train("火车"),plane("飞机");
	
	private String name;
	private TransportType(String name){
		this.name =name;
	}
	
	public String getName(){
		return this.name;
	}
}
