package po;

import java.io.Serializable;

public enum Formstate implements Serializable{
	waiting("待审批"),pass("通过"),fail("否决"),checked("已查看");
	
	private String name;

	private Formstate(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
