package businesslogic.orderbl.OrderPack;

import java.util.List;

import po.Formstate;
import po.Ordertype;
import po.ResultMessage;
import vo.OrderFareVO;
import vo.OrderVO;

public class Order {
	AddOrder add;
	GetPrice getPrice;
	GetOrderCode getcode;
	FindOrder findOrder;
	String orgcode;
	public Order(AddOrder add,String orgcode){
		this.add=add;
		this.orgcode=orgcode;

	}
	public Order(GetPrice getPrice){
		this.getPrice=getPrice;
	}
	public Order(GetOrderCode getcode,String orgcode){
		this.getcode=getcode;
		this.orgcode=orgcode;
	}
	public Order(FindOrder findOrder){
		this.findOrder=findOrder;
	}
	public ResultMessage addOrder(OrderVO vo){
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
		String  packagetype=vo.getPackagetype();
		String ordercode=vo.getOrdercode();
		Ordertype ordertype=vo.getOrdertype();
		double totalfee=vo.getTotalfee();
		Formstate documentstate=vo.getFormstate();
		add.setOrder(orgcode, sendername, senderaddress, senderunit, senderphone, sendercellphone, receivername, 
				receiveraddress, receiverunit, receiverphone, receivercellphone, numbers, weight, volume, 
				productname, packagetype, totalfee, ordercode, ordertype,documentstate);
		ResultMessage result=add.addOrder();
		return result;
	}
	
	public double getPrice(OrderFareVO vo){
		String senderaddress=vo.getSenderaddress();
		String receiveraddress=vo.getReceiveraddress();
		double numbers=vo.getNumbers();
		double weight=vo.getWeight();
		double volume=vo.getVolume();
		String  packagetype=vo.getPackagetype();
		Ordertype ordertype=vo.getOrdertype();
		getPrice.setPriceInfo(senderaddress, receiveraddress, numbers, weight, volume, packagetype, ordertype);
		double price=getPrice.getPrice();
		return price;
	}
	public String getOrdercode(){
		String code=getcode.getCode(orgcode);
		return code;
	}
    public List<OrderVO> findOrderByState(Formstate documentstate,String orgcode){
    	findOrder.setstate(documentstate,orgcode);
    	List<OrderVO> listvo=findOrder.findOrderbyState();
    	return listvo;
    }
}
