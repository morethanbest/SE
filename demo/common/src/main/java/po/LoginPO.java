package po;

import java.io.Serializable;

public class LoginPO implements Serializable {
	String username;
	StaffPO staff;
	public LoginPO(String username, StaffPO po) {
		this.username = username;
		this.staff = po;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public StaffPO getStaff() {
		return staff;
	}
	public void setStaff(StaffPO po) {
		this.staff = po;
	}
	
	
}
