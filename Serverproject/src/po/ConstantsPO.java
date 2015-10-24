package po;

import java.io.Serializable;

public class ConstantsPO implements Serializable{
	long id;
	String name;
	double value;
	public ConstantsPO(long id, String name, double value) {
		this.id = id;
		this.name = name;
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public long getId() {
		return id;
	}
	
}
