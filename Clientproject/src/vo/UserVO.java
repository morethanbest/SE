package vo;

public class UserVO{
	String username;
	String password;
	String level;
	public UserVO( String username, String password, String level) {

		this.username = username;
		this.password = password;
		this.level = level;
	}
	public String getCode() {
		return password;
	}
	public String getLevel() {
		return level;
	}
	public String getUsername() {
		return username;
	}
	
	
}