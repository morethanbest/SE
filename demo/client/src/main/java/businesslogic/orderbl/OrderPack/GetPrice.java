package businesslogic.orderbl.OrderPack;

import po.Ordertype;

public class GetPrice {
	String senderaddress;
	String receiveraddress;
	double numbers;
	double weight;
	double volume;
	double productsize;
	double packagefee;
	Ordertype ordertype;
	public void setPriceInfo(String senderaddress,String receiveraddress,double numbers,double weight,
			double volume,double productsize,double packagefee,Ordertype ordertype){
		this.senderaddress=senderaddress;
		this.receiveraddress=receiveraddress;
		this.numbers=numbers;
		this.weight=weight;
		this.volume=volume;
		this.productsize=productsize;
		this.packagefee=packagefee;
		this.ordertype=ordertype;
	}
	public double getPrice(){
		//寰呭父閲忓畬鎴愬悗濉啓锛侊紒锛�
		return 10;
	}

}
