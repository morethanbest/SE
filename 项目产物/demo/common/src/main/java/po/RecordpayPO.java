package po;
import java.io.Serializable;


public class RecordpayPO  implements Serializable{
	String id;
	long paytime;
	double paysum;
	String payman;
	String payaccount;
	RecordpayList entry;
	String remark;
	Formstate formstate;
	public RecordpayPO(String id,long paytime, double paysum, String payman, String payaccount,RecordpayList entry,
					   String remark,Formstate formstate) {
		this.id=id;
		this.paytime = paytime;
		this.paysum = paysum;
		this.payman = payman;
		this.payaccount = payaccount;
		this.entry=entry;
		this.remark = remark;
		this.formstate=formstate;
	}

	public String getId() {
		return id;
	}

	public long getPaytime() {
		return paytime;
	}

	public double getPaysum() {
		return paysum;
	}

	public String getPayman() {
		return payman;
	}

	public String getPayaccount() {
		return payaccount;

	}

	public RecordpayList getEntry() {
		return entry;
	}

	public String getRemark() {
		return remark;
	}

	public Formstate getFormstate() {
		return formstate;
	}


	public void setId(String id) {
		this.id = id;
	}

	public void setPaytime(long paytime) {
		this.paytime = paytime;
	}

	public void setPaysum(double paysum) {
		this.paysum = paysum;

	}

	public void setPayman(String payman) {
		this.payman = payman;
	}

	public void setPayaccount(String payaccount) {
		this.payaccount = payaccount;
	}

	public void setEntry(RecordpayList entry) {
		this.entry = entry;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setFormstate(Formstate formstate) {
		this.formstate = formstate;
	}
}
