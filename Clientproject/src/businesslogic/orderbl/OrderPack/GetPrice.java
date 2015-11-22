package businesslogic.orderbl.OrderPack;

import java.rmi.RemoteException;

import po.Ordertype;
import data.orderdata.OrderFormData;
import dataservice.orderdataservice.OrderFormDataService;

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
		//待常量完成后填写！！！
		return 10;
	}

}
