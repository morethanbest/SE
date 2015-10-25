package po;

import java.io.Serializable;

public class DeliveryPO  implements Serializable{
	long id;
	long arrivaltime;
	long barcode;
	String delivorinfo;
	Formstate documentstate;
	
	public DeliveryPO(long id,long arrivaltime,long barcode,String delivorinfo){
		this.arrivaltime=arrivaltime;
		this.barcode=barcode;
		this.delivorinfo=delivorinfo;
		this.documentstate=Formstate.waiting;
	}
	public long getId() {
		return id;
	}
	public void setDocumentstate(Formstate documentstate){
		this.documentstate=documentstate;
	}
	
	public void setArrivaltime(long arrivaltime) {
		this.arrivaltime = arrivaltime;
	}

	public void setBarcode(long barcode) {
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
	public long getBarcode(){
		return this.barcode;
	}
	public String getDelivorinfo(){
		return this.delivorinfo;
	}
	
}
