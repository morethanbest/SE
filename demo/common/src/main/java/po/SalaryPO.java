package po;
import java.io.Serializable;

public class SalaryPO implements Serializable{
	Job job;
	SalaryMode salarymode;
	double base;
	double bonus;
	public SalaryPO( Job job, SalaryMode salarymode, double base, double bonus) {
		this.job = job;
		this.salarymode = salarymode;
		this.base = base;
		this.bonus = bonus;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public SalaryMode getSalarymode() {
		return salarymode;
	}
	public void setSalarymode(SalaryMode salarymode) {
		this.salarymode = salarymode;
	}
	public double getBase() {
		return base;
	}
	public void setBase(double base) {
		this.base = base;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
		
	
}
