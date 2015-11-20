package po;
import java.io.Serializable;
import java.util.LinkedList;


public class UserPO implements Serializable {
	long id;
	String username;
	String password;
	Job job;
	Hall hall;
	public UserPO(long id, String username, String password, Job job,Hall hall) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.job=job;
		this.hall=hall;
	}

	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
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
