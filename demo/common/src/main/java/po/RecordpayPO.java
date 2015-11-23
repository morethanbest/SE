package po;
import java.io.Serializable;

public class RecordpayPO  implements Serializable{
	long id;
	long paytime;
	double paysum;
	String payman;
	String payaccount;
	double rent;
	double fee;
	double salary;
	double reward;
	String remark;
	Formstate documentstate;
	public RecordpayPO(long id,long paytime, double paysum, String payman, String payaccount, double rent, double fee,
			double salary, double reward, String remark) {
		this.id=id;
		this.paytime = paytime;
		this.paysum = paysum;
		this.payman = payman;
		this.payaccount = payaccount;
		this.rent = rent;
		this.fee = fee;
		this.salary = salary;
		this.reward = reward;
		this.remark = remark;
		this.documentstate=Formstate.waiting;
	}
	public long getId() {
		return id;
	}
	public long getPaytime() {
		return paytime;
	}
	public void setPaytime(long paytime) {
		this.paytime = paytime;
	}
	public double getPaysum() {
		return paysum;
	}
	public void setPaysum(long paysum) {
		this.paysum = paysum;
	}
	public String getPayman() {
		return payman;
	}
	public void setPayman(String payman) {
		this.payman = payman;
	}
	public String getPayaccount() {
		return payaccount;
	}
	public void setPayaccount(String payaccount) {
		this.payaccount = payaccount;
	}
	public double getRent() {
		return rent;
	}
	public void setRent(double rent) {
		this.rent = rent;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getReward() {
		return reward;
	}
	public void setReward(double reward) {
		this.reward = reward;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Formstate getDocumentstate() {
		return documentstate;
	}
	public void setDocumentstate(Formstate documentstate) {
		this.documentstate = documentstate;
	}
	
	
}
