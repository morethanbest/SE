package vo;

public class RecordpayVO {
	long paytime;
	long paysum;
	String payman;
	String payaccount;
	double rent;
	double fee;
	double salary;
	double reward;
	String remark;
	public RecordpayVO(long paytime, long paysum, String payman,
			String payaccount, double rent, double fee, double salary,
			double reward, String remark) {
		super();
		this.paytime = paytime;
		this.paysum = paysum;
		this.payman = payman;
		this.payaccount = payaccount;
		this.rent = rent;
		this.fee = fee;
		this.salary = salary;
		this.reward = reward;
		this.remark = remark;
	}
	public long getPaytime() {
		return paytime;
	}
	public long getPaysum() {
		return paysum;
	}
	public String getPayman() {
		return payman;
	}
	public String getPayaccount() {
		return payaccount;
	}
	public double getRent() {
		return rent;
	}
	public double getFee() {
		return fee;
	}
	public double getSalary() {
		return salary;
	}
	public double getReward() {
		return reward;
	}
	public String getRemark() {
		return remark;
	}
}
