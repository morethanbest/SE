package po;
import java.io.Serializable;
import java.util.LinkedList;


public class UserPO implements Serializable {
	long id;
	String username;
	String password;
	Job job;
	public UserPO(long id, String username, String password, Job job) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.job=job;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	
	
}
