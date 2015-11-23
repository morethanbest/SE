package vo;

public class UserVO{
	long id;
	String username;
	String password;
	String level;
	public UserVO( long id,String username, String password, String level) {
		this.id=id;
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
	public long getID(){
		return id;
	}
	
	
}