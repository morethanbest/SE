package vo;

public class HLFareVO {
	String destination;
	String departure;
	public HLFareVO(String destination, String departure) {
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
