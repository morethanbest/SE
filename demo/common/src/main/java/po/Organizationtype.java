package po;

import java.io.Serializable;

public enum Organizationtype implements Serializable{
	hall("营业厅"),transfercenter("中转中心"),headquarters("总部");
	
	private String name;
	
	private Organizationtype(String name){
		this.name=name;
	}
	
	public String getName(){
		return this.name;
	}
}
