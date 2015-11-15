package po;
import java.io.Serializable;
import java.util.LinkedList;


public class UserPO implements Serializable {
	long id;
	String username;
	String password;
	String level;
	public UserPO(long id, String username, String password, String level) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.level = level;
	}
	public String getCode() {
		return password;
	}
	public void setCode(String code) {
		this.password = code;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	
	
}
