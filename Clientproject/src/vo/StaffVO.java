package vo;

import po.Job;

public class StaffVO {
	String name;
	Job job;
	public StaffVO(String name, Job job) {
		this.name = name;
		this.job = job;
	}
	public String getName() {
		return name;
	}
	public Job getJob() {
		return job;
	}

}