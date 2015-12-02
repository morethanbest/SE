package vo;

import po.Ordertype;

public class OrderVO {
	String sendername;
	String senderaddress;
	String senderunit;
	String senderphone;
	String sendercellphone;
	String receivername;
	String receiveraddress;
	String receiverunit;
	String receiverphone;
	String receivercellphone;
	double numbers;
	double weight;
	double volume;
	String productname;
	String packagetype;
	String ordercode;
	Ordertype ordertype;
	double totalfee;
	
	public OrderVO(String sendername,String senderaddress,String senderunit,String senderphone,String sendercellphone,String receivername,
			String receiveraddress,String receiverunit,String receiverphone,String receivercellphone,
			double numbers,double weight,double volume,String productname,String packagetype,String ordercode,Ordertype ordertype,double totalfee){
		this.sendername=sendername;
		this.senderaddress=senderaddress;
		this.senderunit=senderunit;
		this.senderphone=senderphone;
		this.sendercellphone=sendercellphone;
		this.receiverphone=receiverphone;
		this.receivercellphone=receivercellphone;
		this.receivername=receivername;
		this.receiveraddress=receiveraddress;
		this.receiverunit=receiverunit;
		this.numbers=numbers;
		this.weight=weight;
		this.volume=volume;
		this.productname=productname;
		this.packagetype=packagetype;
		this.ordercode=ordercode;
		this.ordertype=ordertype;
		this.totalfee=totalfee;
	}

	public String getReceivername() {
		return receivername;
	}

	public String getReceiveraddress() {
		return receiveraddress;
	}

	public String getReceiverunit() {
		return receiverunit;
	}

	public String getSendername(){
		return this.sendername;
	}
	public String getSenderaddress(){
		return this.senderaddress;
	}
	public String getSenderunit(){
		return this.senderunit;
	}
	public String getSenderphone(){
		return this.senderphone;
	}
	public String getSendercellphone(){
		return this.sendercellphone;
	}
	public String getReceiverphone(){
		return this.receiverphone;
	}
	public String getReceivercellphone(){
		return this.sendercellphone;
	}
	public double getNumbers(){
		return this.numbers;
	}
	public double getWeight(){
		return this.weight;
	}
	public double getVolume(){
		return this.volume;
	}
	public String getProductname(){
		return this.productname;
	}
	public String getPackagetype(){
		return this.packagetype;
	}
	public String getOrdercode(){
		return this.ordercode;
	}
	public Ordertype getOrdertype(){
		return this.ordertype;
	}
	public double getTotalfee(){
		return this.totalfee;
	}
}
