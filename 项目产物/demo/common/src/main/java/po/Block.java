package po;

import java.io.Serializable;

public enum Block implements Serializable{
	flight("航运区",1),train("铁运区",2),truck("汽运区",3),flexible("机动区",4);
	
	private String name;
	private long blocknum;
	private Block(String name,long blocknum){
		this.name=name;
		this.blocknum=blocknum;
		
	}
	public String getName() {
		return name;
	}
	public long getBlocknum() {
		return blocknum;
	}
	
}
