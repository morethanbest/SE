package po;

import java.io.Serializable;

public class CityPO implements Serializable{
	String name;
	String zone;
	public CityPO(String name, String zone) {
		this.name = name;
		this.zone = zone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	
}
