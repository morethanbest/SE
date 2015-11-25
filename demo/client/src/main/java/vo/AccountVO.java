package vo;


public class AccountVO {
	String accountname;
	double accountsum;
	public AccountVO(String accountname, double accountsum) {
		this.accountname = accountname;
		this.accountsum = accountsum;
	}
	public String getAccountname() {
		return accountname;
	}
	public double getAccountsum() {
		return accountsum;
	}
	
}
