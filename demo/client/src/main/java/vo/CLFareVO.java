package vo;

import po.City;
import po.Hall;

public class CLFareVO {
	Hall destination;
	City departure;
	public CLFareVO(Hall destination, City departure) {
		super();
		this.destination = destination;
		this.departure = departure;
	}
	public Hall getDestination() {
		return destination;
	}
	public City getDeparture() {
		return departure;
	}
}
