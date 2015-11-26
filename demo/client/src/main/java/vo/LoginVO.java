package vo;

import po.Job;

public class LoginVO {
	String username;
	String String;
	Job job;
	public LoginVO(String username, String String, Job job) {
		this.username = username;
		this.String = String;
		this.job = job;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getString() {
		return String;
	}
	public void setString(String String) {
		this.String = String;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
}
