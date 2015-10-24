import java.io.Serializable;

public class StocktakingPO  implements Serializable{
	long id;
	double income;
	double pay;
	double allbenefit;
	public StocktakingPO(long id,double income, double pay, double allbenefit) {
		this.id=id;
		this.income = income;
		this.pay = pay;
		this.allbenefit = allbenefit;
	}
	public long getId() {
		return id;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public double getPay() {
		return pay;
	}
	public void setPay(double pay) {
		this.pay = pay;
	}
	public double getAllbenefit() {
		return allbenefit;
	}
	public void setAllbenefit(double allbenefit) {
		this.allbenefit = allbenefit;
	}
	
}
