import java.io.Serializable;

public class DebitnotePO  implements Serializable{
	long id;
	long debittime;
	String debitunit;
	String debitor;
	String debitside;
	double sum;
	String location;
	Formstate documentstate;
	public DebitnotePO(long id,long debittime, String debitunit, String debitor, String debitside, double sum,
			String location) {
		this.id=id;
		this.debittime = debittime;
		this.debitunit = debitunit;
		this.debitor = debitor;
		this.debitside = debitside;
		this.sum = sum;
		this.location = location;
		this.documentstate=Formstate.waiting;
	}
	public long getId() {
		return id;
	}
	public void setDebittime(long debittime) {
		this.debittime = debittime;
	}
	public void setDebitunit(String debitunit) {
		this.debitunit = debitunit;
	}
	public void setDebitor(String debitor) {
		this.debitor = debitor;
	}
	public void setDebitside(String debitside) {
		this.debitside = debitside;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Formstate getDocumentstate() {
		return documentstate;
	}
	public void setDocumentstate(Formstate documentstate) {
		this.documentstate = documentstate;
	}
	public long getDebittime() {
		return debittime;
	}
	public String getDebitunit() {
		return debitunit;
	}
	public String getDebitor() {
		return debitor;
	}
	public String getDebitside() {
		return debitside;
	}
	public double getSum() {
		return sum;
	}
	public String getLocation() {
		return location;
	}
	
}	
