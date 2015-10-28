package dataservice.orderdataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.OrdersPO;

public interface OrderFormDataService {
	public void addOrderForm (OrdersPO po)throws RemoteException;
	
	public OrdersPO getOrderForm (long ordernum)throws RemoteException;
	
	public List<OrdersPO> getOrderForm (Formstate state)throws RemoteException;
	
	public void updateOrderForm (OrdersPO po)throws RemoteException;
}
