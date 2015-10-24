package vo;

import po.Formstate;


public class DeliveryExamVO {
	long arrivaltime;
	String barcode;
	String delivorinfo;
	Formstate documentstate;
	
	public DeliveryExamVO(long arrivaltime,String barcode,String delivorinfo){
		this.arrivaltime=arrivaltime;
		this.barcode=barcode;
		this.delivorinfo=delivorinfo;
		this.documentstate=Formstate.waiting;
	}
	public void setDocumentstate(Formstate documentstate){
		this.documentstate=documentstate;
	}
	
	public void setArrivaltime(long arrivaltime) {
		this.arrivaltime = arrivaltime;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public void setDelivorinfo(String delivorinfo) {
		this.delivorinfo = delivorinfo;
	}

	public Formstate getDocumentstate(){
		return this.documentstate;
	}
	public long getArrivaltime(){
		return this.arrivaltime;
	}
	public String getBarcode(){
		return this.barcode;
	}
	public String getDelivorinfo(){
		return this.delivorinfo;
	}
	
}
