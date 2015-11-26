package vo;

import po.City;

public class CLFareVO {
	String destination;
	City departure;
	public CLFareVO(String destination, City departure) {
		super();
		this.destination = destination;
		this.departure = departure;
	}
	public String getDestination() {
		return destination;
	}
	public City getDeparture() {
		return departure;
	}
}
