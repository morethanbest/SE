
public class OrignalAccountPO {
	String accountname;
	double accountsum;
	long id;
	public OrignalAccountPO(String accountname, double accountsum, long id) {
		this.accountname = accountname;
		this.accountsum = accountsum;
		this.id = id;
	}
	public String getAccountname() {
		return accountname;
	}
	public double getAccountsum() {
		return accountsum;
	}
	public long getId() {
		return id;
	}
}
