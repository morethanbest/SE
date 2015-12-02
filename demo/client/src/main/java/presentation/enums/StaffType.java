package presentation.enums;

import po.Job;

public enum StaffType {
	Courior("快递员", Job.Courier), HallStaff("营业厅业务员",Job.hallsalesman), CenterStaff("中转中心业务员", Job.transfercentersalesman), CenterDepot("中转中心库存管理人员",Job.CenterDepot), Financial("财务人员", Job.Financial), Manager("总经理", Job.manager);
	private String name;
	private Job job;
	private StaffType(String name, Job job) {
		this.name = name;
		this.job = job;
	}

	public String getName() {
		return name;
	}

	public Job getJob() {
		return job;
	}
}
