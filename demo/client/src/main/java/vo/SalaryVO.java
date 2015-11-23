package vo;

import po.Job;
import po.SalaryMode;

public class SalaryVO {
	Job job;
	SalaryMode salarymode;
	double base;
	double bonus;
	public SalaryVO(Job job, SalaryMode salarymode, double base, double bonus) {
		super();
		this.job = job;
		this.salarymode = salarymode;
		this.base = base;
		this.bonus = bonus;
	}
	public Job getJob() {
		return job;
	}
	public SalaryMode getSalarymode() {
		return salarymode;
	}
	public double getBase() {
		return base;
	}
	public double getBonus() {
		return bonus;
	}
}
