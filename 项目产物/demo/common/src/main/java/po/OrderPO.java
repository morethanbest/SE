package po;

import java.io.Serializable;

public class OrderPO  implements Serializable{
	String orgcode;//
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
	double totalfee;
	String ordercode;
	Ordertype ordertype;
	String codeofreceiving;//
	String receiver;//
	long receivingtime;//
	Formstate documentstate;	
	
	public OrderPO(String orgcode,String sendername,String senderaddress,String senderunit,String senderphone,String sendercellphone,String receivername,
			String receiveraddress,String receiverunit,String receiverphone,String receivercellphone,double numbers,double weight,
			double volume,String productname,String packagetype,double totalfee,String ordercode,Ordertype ordertype,Formstate documentstate){
		this.orgcode=orgcode;
		this.sendername=sendername;
		this.senderaddress=senderaddress;
		this.senderunit=senderunit;
		this.senderphone=senderphone;
		this.sendercellphone=sendercellphone;
		this.receivername=receivername;
		this.receiveraddress=receiveraddress;
		this.receiverunit=receiverunit;
		this.receiverphone=receiverphone;
		this.receivercellphone=receivercellphone;
		this.numbers=numbers;
		this.weight=weight;
		this.volume=volume;
		this.productname=productname;
		this.packagetype=packagetype;
		this.totalfee=totalfee;
		this.ordercode=ordercode;
		this.ordertype=ordertype;
		this.codeofreceiving="";
		this.receiver="";
		this.receivingtime=0;
		this.documentstate=documentstate;
	}
	public OrderPO(String orgcode, String sendername, String senderaddress, String senderunit, String senderphone,
			String sendercellphone, String receivername, String receiveraddress, String receiverunit,
			String receiverphone, String receivercellphone, double numbers, double weight, double volume,
			String productname, String packagetype, double totalfee, String ordercode,
			Ordertype ordertype, String codeofreceiving, String receiver, long receivingtime, Formstate documentstate) {
		this.orgcode = orgcode;
		this.sendername = sendername;
		this.senderaddress = senderaddress;
		this.senderunit = senderunit;
		this.senderphone = senderphone;
		this.sendercellphone = sendercellphone;
		this.receivername = receivername;
		this.receiveraddress = receiveraddress;
		this.receiverunit = receiverunit;
		this.receiverphone = receiverphone;
		this.receivercellphone = receivercellphone;
		this.numbers = numbers;
		this.weight = weight;
		this.volume = volume;
		this.productname = productname;
		this.packagetype = packagetype;
		this.totalfee = totalfee;
		this.ordercode = ordercode;
		this.ordertype = ordertype;
		this.codeofreceiving = codeofreceiving;
		this.receiver = receiver;
		this.receivingtime = receivingtime;
		this.documentstate = documentstate;
	}
	public String getOrgcode() {
		return orgcode;
	}
	public void setReceive(String codeofreceiving,String receiver,long receivingtime){
		this.codeofreceiving=codeofreceiving;
		this.receiver=receiver;
		this.receivingtime=receivingtime;
	}
	
	public void setDocumentstate(Formstate documentstate){
		this.documentstate=documentstate;
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

	public void setPackagetype(String  packagetype) {
		this.packagetype = packagetype;
	}

	public void setTotalfee(double totalfee) {
		this.totalfee = totalfee;
	}

	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}

	public void setOrdertype(Ordertype ordertype) {
		this.ordertype = ordertype;
	}
	public void setReceiver(String receiver){
		this.receiver=receiver;
	}
	public void setReceivingtime(long receivingtime){
		this.receivingtime=receivingtime;
	}
	public void setFormstate(Formstate documentstate){
	    this.documentstate=documentstate;
	}
	public Formstate getDocumentstate(){
		return this.documentstate;
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
	public String getReceivername(){
		return this.receivername;
	}
	public String getReceiveraddress(){
		return this.receiveraddress;
	}
	public String getReceiverunit(){
		return this.receiverunit;
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

	public String  getPackagetype(){
		return this.packagetype;
	}
	public double getTotalfee(){
		return this.totalfee;
	}
	public String getOrdercode(){
		return this.ordercode;
	}
	public Ordertype getOrdertype(){
		return this.ordertype;
	}
	public String getCodeofreceiving(){
		return this.codeofreceiving;
	}
	public String getReceiver(){
		return this.receiver;
	}
	public long getReceivingtime(){
		return this.receivingtime;
	}
}
