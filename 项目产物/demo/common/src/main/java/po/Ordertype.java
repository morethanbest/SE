package po;

import java.io.Serializable;

public enum Ordertype implements Serializable{
	economical("经济快递"),normal("标准快递"),fast("特快");
	private String name;

	private Ordertype(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
