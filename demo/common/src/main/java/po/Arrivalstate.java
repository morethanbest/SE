package po;

import java.io.Serializable;

public enum Arrivalstate implements Serializable {
	intact("完整"),broken("破损"),lost("丢失");
	
	private String name;

	private Arrivalstate(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
