package dataservice.orderdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.OrderPO;
import po.ResultMessage;

public interface OrderFormDataService extends Remote {
	public ResultMessage addOrderForm (OrderPO po)throws RemoteException;
	
	public OrderPO getOrderForm (String ordernum)throws RemoteException;
	
	public List<OrderPO> getOrderForm (Formstate state)throws RemoteException;
	
	public ResultMessage updateOrderForm (OrderPO po)throws RemoteException;
	
	public long findLastID() throws RemoteException;
}
