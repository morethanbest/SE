package po;

import java.io.Serializable;

public class OrignalStaffPO implements Serializable {
	long id;
	String name;
	Job job;
	public OrignalStaffPO(long id, String name, Job job) {
		this.id = id;
		this.name = name;
		this.job = job;
	}
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Job getJob() {
		return job;
	}
}
