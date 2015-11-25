package vo;

import po.City;
import po.Job;
import po.Organizationtype;

public class StaffVO {
	long id;
	String name;
	Job job;
	String organizationname;
	String organizationcode;
	Organizationtype organizationtype;
	City city;
	public StaffVO(long id, String name, Job job, String organizationname, String organizationcode,
				   Organizationtype organizationtype, City city) {
		this.id=id;
		this.name=name;
		this.job=job;
		this.organizationname=organizationname;
		this.organizationcode=organizationcode;
		this.organizationtype=organizationtype;
		this.city=city;
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
    public Organizationtype getOrganizationtype(){
	    return organizationtype;
    }
	public String getOrganizationname(){
		return organizationname;
	}
	public String getOrganizationcode(){
		return organizationcode;
	}
	public City getCity(){
		return city;
	}
}