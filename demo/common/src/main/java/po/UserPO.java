package po;
import java.io.Serializable;
import java.util.LinkedList;


public class UserPO implements Serializable {
	long id;
	String username;
	String password;
	Job job;
	String organizationname;
	String organizationcode;
	Organizationtype organizationtype;
	City city;
	public UserPO(long id, String username, String password, Job job, String organizationname, String organizationcode,
			Organizationtype organizationtype, City city) {
		this.id = id;
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
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
