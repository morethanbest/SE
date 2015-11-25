package po;
import java.io.Serializable;
import java.util.LinkedList;


public class UserPO implements Serializable {
	long id;
	String username;
	String password;
	StaffPO staff;
	public UserPO(long id, String username, String password, StaffPO staff) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.staff = staff;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public StaffPO getStaff() {
		return staff;
	}
	public void setStaff(StaffPO staff) {
		this.staff = staff;
	}
	public long getId() {
		return id;
	}
	
	
	
}
