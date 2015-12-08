package po;

import java.io.Serializable;
import java.net.PortUnreachableException;

public enum SalaryMode implements Serializable {
	chargebytimes("计次"),monthly("月薪"),deduct("提成");
	
	private String name;
	
	private SalaryMode(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
}
