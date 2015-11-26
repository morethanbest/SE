package vo;

import po.Ordertype;

public class OrderFareVO {
	String senderaddress;
	String receiveraddress;
	double numbers;
	double weight;
	double volume;
	double packagefee;
	Ordertype ordertype;
	public OrderFareVO(String senderaddress, String receiveraddress,
			double numbers, double weight, double volume, 
			double packagefee, Ordertype ordertype) {
		super();
		this.senderaddress = senderaddress;
		this.receiveraddress = receiveraddress;
		this.numbers = numbers;
		this.weight = weight;
		this.volume = volume;
		this.packagefee = packagefee;
		this.ordertype = ordertype;
	}
	public String getSenderaddress() {
		return senderaddress;
	}
	public String getReceiveraddress() {
		return receiveraddress;
	}
	public double getNumbers() {
		return numbers;
	}
	public double getWeight() {
		return weight;
	}
	public double getVolume() {
		return volume;
	}
	public double getPackagefee() {
		return packagefee;
	}
	public Ordertype getOrdertype() {
		return ordertype;
	}

}
