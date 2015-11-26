	package vo;


import po.Formstate;

public class DeliveryVO {

	long id;
	long arrivaltime;
	String barcode;
	String delivorinfo;

	Formstate documentstate;
	
	public DeliveryVO(long id,long arrivaltime,String barcode,String delivorinfo,Formstate documentstate){
		this.id=id;
		this.arrivaltime=arrivaltime;
		this.barcode=barcode;
		this.delivorinfo=delivorinfo;
		this.documentstate=documentstate;
	}
	public long getid(){return this.id;}
	public long getArrivaltime(){
		return this.arrivaltime;
	}
	public String getBarcode(){
		return this.barcode;
	}
	public String getDelivorinfo(){
		return this.delivorinfo;
	}
	public Formstate getDocumentstate(){
		return this.documentstate;
	}
}