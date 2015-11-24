package businesslogic.orderbl.OrderPack;

import po.Ordertype;
import po.ResultMessage;
import vo.OrderFareVO;
import vo.OrderVO;

public class Order {
	AddOrder add;
	GetPrice getPrice;
	IdInfo Id;
	GetOrderCode getcode;
	public Order(AddOrder add,IdInfo Id){
		this.add=add;
		this.Id=Id;
	}
	public Order(GetPrice getPrice){
		this.getPrice=getPrice;
	}
	public Order(GetOrderCode getcode){
		this.getcode=getcode;
	}
	public ResultMessage addOrder(OrderVO vo){
		long id=Id.getId();
		String code=getcode.getCode();
		String sendername=vo.getSendername();
		String senderaddress=vo.getSenderaddress();
		String senderunit=vo.getSenderunit();
		String senderphone=vo.getSenderphone();
		String sendercellphone=vo.getSendercellphone();
		String receivername=vo.getReceivername();
		String receiveraddress=vo.getReceiveraddress();
		String receiverunit=vo.getReceiverunit();
		String receiverphone=vo.getReceiverphone();
		String receivercellphone=vo.getReceivercellphone();
		double numbers=vo.getNumbers();
		double weight=vo.getWeight();
		double volume=vo.getVolume();
		String productname=vo.getProductname();
		double productsize=vo.getProductsize();
		double packagefee=vo.getPackagefee();
		String ordercode=vo.getOrdercode();
		Ordertype ordertype=vo.getOrdertype();
		OrderFareVO farevo=new OrderFareVO(senderaddress, receiveraddress, numbers, weight, volume, productsize, packagefee, ordertype);
		double totalfee=this.getPrice(farevo);
		add.setOrder(id, sendername, senderaddress, senderunit, senderphone, sendercellphone, receivername, 
				receiveraddress, receiverunit, receiverphone, receivercellphone, numbers, weight, volume, 
				productname, productsize, packagefee, totalfee, ordercode, ordertype);
		ResultMessage result=add.addOrder();
		return result;
	}
	
	public double getPrice(OrderFareVO vo){
		String senderaddress=vo.getSenderaddress();
		String receiveraddress=vo.getReceiveraddress();
		double numbers=vo.getNumbers();
		double weight=vo.getWeight();
		double volume=vo.getVolume();
		double productsize=vo.getProductsize();
		double packagefee=vo.getPackagefee();
		Ordertype ordertype=vo.getOrdertype();
		getPrice.setPriceInfo(senderaddress, receiveraddress, numbers, weight, volume, productsize, packagefee, ordertype);
		double price=getPrice.getPrice();
		return price;
	}
	public String getOrdercode(){
		String code=getcode.getCode();
		return code;
	}

}
