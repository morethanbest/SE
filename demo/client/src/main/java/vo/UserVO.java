package vo;

import po.City;
import po.Job;
import po.Organizationtype;

public class UserVO{
	String username;
	String password;
	Job job;
	String organizationname;
	String organizationcode;
	Organizationtype organizationtype;
	City city;
	public UserVO(String username, String password, Job job, String organizationname, String organizationcode,
			Organizationtype organizationtype, City city) {
		this.username = username;
		this.password = password;
		this.job = job;
		this.organizationname = organizationname;
		this.organizationcode = organizationcode;
		this.organizationtype = organizationtype;
		this.city = city;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public Job getJob() {
		return job;
	}
	public String getOrganizationname() {
		return organizationname;
	}
	public String getOrganizationcode() {
		return organizationcode;
	}
	public Organizationtype getOrganizationtype() {
		return organizationtype;
	}
	public City getCity() {
		return city;
	}

	
}