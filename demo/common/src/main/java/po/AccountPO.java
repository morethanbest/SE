package po;

import java.io.Serializable;

public class AccountPO  implements Serializable{
	String accountname;
	double accountsum;
	public AccountPO(String accountname, double accountsum) {
		this.accountname = accountname;
		this.accountsum = accountsum;
	}
	public String getAccountname() {
		return accountname;
	}
	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}
	public double getAccountsum() {
		return accountsum;
	}
	public void setAccountsum(double accountsum) {
		this.accountsum = accountsum;
	}
	
}
