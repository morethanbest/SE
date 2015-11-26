package vo;

import po.City;
import po.Job;
import po.Organizationtype;

public class LoginVO {
	String username;
	Job job;
	String organizationname;
	String organizationcode;
	Organizationtype organizationtype;
	City city;
	public LoginVO(String username, Job job, String organizationname, String organizationcode, Organizationtype organizationtype, City city) {
		this.username = username;
		this.job = job;
		this.organizationname=organizationname;
		this.organizationcode=organizationcode;
		this.organizationtype=organizationtype;
		this.city=city;
	}
	public String getUsername() {
		return username;
	}
	public Job getJob() {
		return job;
	}
	public String getOrganizationname(){
		return organizationname;
	}
	public String getOrganizationcode(){
		return organizationcode;
	}
	public Organizationtype getOrganizationtype(){
		return organizationtype;
	}
	public City getCity(){
		return city;
	}
}
