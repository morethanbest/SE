package vo;


public class AccountVO {
	long id;
	String accountname;
	double accountsum;
	public AccountVO(long id,String accountname, double accountsum) {
		this.id=id;
		this.accountname = accountname;
		this.accountsum = accountsum;
	}
	public long getId() {
		return id;
	}
	public String getAccountname() {
		return accountname;
	}
	public double getAccountsum() {
		return accountsum;
	}
	
}
