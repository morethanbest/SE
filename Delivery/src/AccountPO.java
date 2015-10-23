import java.io.Serializable;

public class AccountPO  implements Serializable{
	String accountname;
	double accountsum;
	long id;
	public AccountPO(long id,String accountname, double accountsum) {
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
