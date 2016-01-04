package po;

import java.io.Serializable;

public class AccountPO  implements Serializable{
	long id;
	String accountname;
	double accountsum;
	public AccountPO(long id,String accountname, double accountsum) {
		this.id=id;
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
	public long getId() {
		return id;
	}
	
}
