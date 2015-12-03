package vo;

import po.Ordertype;

public class OrderFareVO {
	String senderaddress;
	String receiveraddress;
	double numbers;
	double weight;
	double volume;
	String  packagetype;
	Ordertype ordertype;
	public OrderFareVO(String senderaddress, String receiveraddress,
			double numbers, double weight, double volume, 
			String packagetype, Ordertype ordertype) {
		super();
		this.senderaddress = senderaddress;
		this.receiveraddress = receiveraddress;
		this.numbers = numbers;
		this.weight = weight;
		this.volume = volume;
		this.packagetype = packagetype;
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
	public String  getPackagetype() {
		return packagetype;
	}
	public Ordertype getOrdertype() {
		return ordertype;
	}

}
