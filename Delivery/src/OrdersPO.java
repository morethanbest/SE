import java.io.Serializable;

public class OrdersPO  implements Serializable{
	long id;
	String sendername;
	String senderaddress;
	String senderunit;
	long senderphone;
	long sendercellphone;
	String receivername;
	String receiveraddress;
	String receiverunit;
	long receiverphone;
	long receivercellphone;
	double numbers;
	double weight;
	double volume;
	String productname;
	double productsize;
	double packagefee;
	double totalfee;
	long ordercode;
	Ordertype ordertype;
	long codeofreceiving;
	String receiver;
	long receivingtime;
	Formstate documentstate;	
	
	public OrdersPO(long id,String sendername,String senderaddress,String senderunit,long senderphone,long sendercellphone,String receivername,
			String receiveraddress,String receiverunit,long receiverphone,long receivercellphone,double numbers,double weight,
			double volume,String productname,double productsize,double packagefee,double totalfee,long ordercode,Ordertype ordertype){
		this.id=id;
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
		this.productsize=productsize;
		this.packagefee=packagefee;
		this.totalfee=totalfee;
		this.ordercode=ordercode;
		this.ordertype=ordertype;
		this.codeofreceiving=0;
		this.receiver="";
		this.receivingtime=0;
		this.documentstate=Formstate.waiting;
	}
	public long getId() {
		return id;
	}
	public void setReceive(long codeofreceiving,String receiver,long receivingtime){
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

	public void setSenderphone(long senderphone) {
		this.senderphone = senderphone;
	}

	public void setSendercellphone(long sendercellphone) {
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

	public void setReceiverphone(long receiverphone) {
		this.receiverphone = receiverphone;
	}

	public void setReceivercellphone(long receivercellphone) {
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

	public void setTotalfee(double totalfee) {
		this.totalfee = totalfee;
	}

	public void setOrdercode(long ordercode) {
		this.ordercode = ordercode;
	}

	public void setOrdertype(Ordertype ordertype) {
		this.ordertype = ordertype;
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
	public long getSenderphone(){
		return this.senderphone;
	}
	public long getSendercellphone(){
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
	public long getReceiverphone(){
		return this.receiverphone;
	}
	public long getReceivercellphone(){
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
	public double getTotalfee(){
		return this.totalfee;
	}
	public long getOrdercode(){
		return this.ordercode;
	}
	public Ordertype getOrdertype(){
		return this.ordertype;
	}
	public long getCodeofreceiving(){
		return this.codeofreceiving;
	}
	public String getReceiver(){
		return this.receiver;
	}
	public long getReceivingtime(){
		return this.receivingtime;
	}
}
