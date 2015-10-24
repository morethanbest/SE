package po;

public class StaffPO {
	long id;
	String name;
	Job job;
	public StaffPO(long id,String name, Job job) {
		this.id=id;
		this.name = name;
		this.job = job;
	}
	public long getId() {
		return id;
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
	
}
