package po;

import java.io.Serializable;

public class StaffPO implements Serializable {
	long id;
	String name;
	Job job;
	OrganizationPO organization;
	public StaffPO(long id, String name, Job job, OrganizationPO organization) {
		this.id = id;
		this.name = name;
		this.job = job;
		this.organization = organization;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public OrganizationPO getOrganization() {
		return organization;
	}
	public void setOrganization(OrganizationPO organization) {
		this.organization = organization;
	}
	public long getId() {
		return id;
	}

	
}
