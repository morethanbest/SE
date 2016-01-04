package vo;

import po.Ordertype;

public class OrderExamVO {
	long id;
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
	double productsize;
	double packagefee;
	String ordercode;
	Ordertype ordertype;
	
	public OrderExamVO(long id,String sendername,String senderaddress,String senderunit,String senderphone,String sendercellphone,String receivername,
			String receiveraddress,String receiverunit,String receiverphone,String receivercellphone,
			double numbers,double weight,double volume,String productname,double productsize,double packagefee,String ordercode,Ordertype ordertype){
		this.id = id;
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
		this.productsize=productsize;
		this.packagefee=packagefee;
		this.ordercode=ordercode;
		this.ordertype=ordertype;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setSendername(String sendername) {
		this.sendername = sendername;
	}

	public void setSenderaddress(String senderaddress) {
		this.senderaddress = senderaddress;
	}

	public void setSenderunit(String senderunit) {
		this.senderunit = senderunit;
	}

	public void setSenderphone(String senderphone) {
		this.senderphone = senderphone;
	}

	public void setSendercellphone(String sendercellphone) {
		this.sendercellphone = sendercellphone;
	}

	public void setReceivername(String receivername) {
		this.receivername = receivername;
	}

	public void setReceiveraddress(String receiveraddress) {
		this.receiveraddress = receiveraddress;
	}

	public void setReceiverunit(String receiverunit) {
		this.receiverunit = receiverunit;
	}

	public void setReceiverphone(String receiverphone) {
		this.receiverphone = receiverphone;
	}

	public void setReceivercellphone(String receivercellphone) {
		this.receivercellphone = receivercellphone;
	}

	public void setNumbers(double numbers) {
		this.numbers = numbers;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public void setProductsize(double productsize) {
		this.productsize = productsize;
	}

	public void setPackagefee(double packagefee) {
		this.packagefee = packagefee;
	}

	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}

	public void setOrdertype(Ordertype ordertype) {
		this.ordertype = ordertype;
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
	public double getProductsize(){
		return this.productsize;
	}
	public double getPackagefee(){
		return this.packagefee;
	}
	public String getOrdercode(){
		return this.ordercode;
	}
	public Ordertype getOrdertype(){
		return this.ordertype;
	}
}
