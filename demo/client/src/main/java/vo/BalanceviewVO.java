package vo;

public class BalanceviewVO {
	double in;
	double out;
	double interest;
	
	public BalanceviewVO(double in, double out, double interest) {
		super();
		this.in = in;
		this.out = out;
		this.interest = interest;
	}
	public double getIn() {
		return in;
	}
	public double getOut() {
		return out;
	}
	public double getInterest() {
		return interest;
	}
	}
