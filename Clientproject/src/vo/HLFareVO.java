package vo;

import po.Hall;

public class HLFareVO {
	Hall destination;
	Hall departure;
	public HLFareVO(Hall destination, Hall departure) {
		super();
		this.destination = destination;
		this.departure = departure;
	}
	public Hall getDestination() {
		return destination;
	}
	public Hall getDeparture() {
		return departure;
	}
}
