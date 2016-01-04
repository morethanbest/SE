package po;

import java.io.Serializable;

public class StaffPO implements Serializable {
	long id;
	String name;
	Job job;
	String organizationname;
	String organizationcode;
	Organizationtype organizationtype;
	String city;
	public StaffPO(long id, String name, Job job, String organizationname, String organizationcode,
			Organizationtype organizationtype, String city) {
		this.id = id;
		this.name = name;
		this.job = job;
		this.organizationname = organizationname;
		this.organizationcode = organizationcode;
		this.organizationtype = organizationtype;
		this.city = city;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getOrganizationname() {
		return organizationname;
	}
	public void setOrganizationname(String organizationname) {
		this.organizationname = organizationname;
	}
	public String getOrganizationcode() {
		return organizationcode;
	}
	public void setOrganizationcode(String organizationcode) {
		this.organizationcode = organizationcode;
	}
	public Organizationtype getOrganizationtype() {
		return organizationtype;
	}
	public void setOrganizationtype(Organizationtype organizationtype) {
		this.organizationtype = organizationtype;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
