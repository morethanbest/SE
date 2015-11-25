package po;

import java.io.Serializable;

public class StaffPO implements Serializable {
	long id;
	String name;
	Job job;
	String organizationname;
	String organizationcode;
	Organizationtype organizationtype;
	City city;
	public StaffPO(long id, String name, Job job, String organizationname, String organizationcode,
			Organizationtype type, City city) {
		this.id = id;
		this.name = name;
		this.job = job;
		this.organizationname = organizationname;
		this.organizationcode = organizationcode;
		this.organizationtype = type;
		this.city = city;
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
	public Organizationtype getType() {
		return organizationtype;
	}
	public void setType(Organizationtype type) {
		this.organizationtype = type;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public long getId() {
		return id;
	}
	
	

	
}
