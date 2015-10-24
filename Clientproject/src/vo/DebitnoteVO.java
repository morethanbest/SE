package vo;

public class DebitnoteVO {
	long debittime;
	String debitunit;
	String debitor;
	String debitside;
	double sum;
	String location;
	public DebitnoteVO(long debittime, String debitunit, String debitor,
			String debitside, double sum, String location) {
		super();
		this.debittime = debittime;
		this.debitunit = debitunit;
		this.debitor = debitor;
		this.debitside = debitside;
		this.sum = sum;
		this.location = location;
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
