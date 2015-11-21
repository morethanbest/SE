package vo;

import po.Job;

public class StaffVO {
	long id;
	String name;
	Job job;
	public StaffVO(long id, String name, Job job) {
		this.id = id;
		this.name = name;
		this.job = job;
	}
	public String getName() {
		return name;
	}
	public Job getJob() {
		return job;
	}
	public long getId(){
		return id;
	}

}