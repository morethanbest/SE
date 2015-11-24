package po;

import java.io.Serializable;

public enum City implements Serializable {
	Beijing("010"),Shanghai("021"),Guangzhou("020"),Nanjing("025");
	
	private final String number;
	
	City(String number){
		this.number=number;
	}
	public String getNumber(){
		return this.number;
	}
	
}
