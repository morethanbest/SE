package po;

public class LoginPO {
	String username;
	Hall hall;
	Job job;
	public LoginPO(String username, Hall hall, Job job) {
		this.username = username;
		this.hall = hall;
		this.job = job;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Hall getHall() {
		return hall;
	}
	public void setHall(Hall hall) {
		this.hall = hall;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	
}
