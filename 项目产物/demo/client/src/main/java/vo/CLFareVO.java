package vo;

public class CLFareVO {
	String destination;
	String departure;
	public CLFareVO(String destination, String departure) {
		super();
		this.destination = destination;
		this.departure = departure;
	}
	public String getDestination() {
		return destination;
	}
	public String getDeparture() {
		return departure;
	}
}
