package businesslogic.orderbl.OrderPack;

import java.rmi.RemoteException;

import data.orderdata.OrderFormData;
import dataservice.orderdataservice.OrderFormDataService;
import po.Formstate;
import po.LogisticsPO;
import po.OrderPO;
import po.Ordertype;
import vo.ResultMessage;

public class AddOrder {
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
	double totalfee;
	String ordercode;
	Ordertype ordertype;
	
	public void setOrder(long id,String sendername,String senderaddress,String senderunit,String senderphone,String sendercellphone,String receivername,
			String receiveraddress,String receiverunit,String receiverphone,String receivercellphone,double numbers,double weight,
			double volume,String productname,Double productsize,double packagefee,double totalfee,String ordercode,Ordertype ordertype){
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

	}
	
	public ResultMessage addOrder(){
		OrderPO po=new OrderPO(id, sendername, senderaddress, senderunit, senderphone, sendercellphone, receivername, 
				receiveraddress, receiverunit, receiverphone, receivercellphone, numbers, weight, volume, productname, 
				productsize, packagefee, totalfee, ordercode, ordertype);
		OrderFormDataService order=new OrderFormData();
		ResultMessage result;
		try {
			result=order.addOrderForm(po);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result=ResultMessage.failure;
			System.out.println("addorder fail");
		}
		return result;
	}
	public ResultMessage addLogisticsPO(){
//		LogisticsPO po=new LogisticsPO(id, state, history, ordernum)
		return ResultMessage.success;
	}
}
