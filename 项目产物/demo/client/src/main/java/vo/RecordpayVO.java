package vo;

import po.Formstate;
import po.RecordpayList;

public class RecordpayVO {
	String id;
	long paytime;
	double paysum;
	String payman;
	String payaccount;
	RecordpayList entry;
	String remark;
	Formstate formstate;
	public RecordpayVO(String id,long paytime, double paysum, String payman, String payaccount,RecordpayList entry,
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
	public void setFormstate(Formstate formstate){
		this.formstate=formstate;
	}
}
