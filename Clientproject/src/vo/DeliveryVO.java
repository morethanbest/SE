package vo;


public class DeliveryVO {
	long arrivaltime;
	String barcode;
	String delivorinfo;
	
	public DeliveryVO(long arrivaltime,String barcode,String delivorinfo){
		this.arrivaltime=arrivaltime;
		this.barcode=barcode;
		this.delivorinfo=delivorinfo;
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