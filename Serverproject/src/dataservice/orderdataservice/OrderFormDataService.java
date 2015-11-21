package dataservice.orderdataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.OrdersPO;
import po.ResultMessage;

public interface OrderFormDataService {
	public ResultMessage addOrderForm (OrdersPO po)throws RemoteException;
	
	public OrdersPO getOrderForm (long ordernum)throws RemoteException;
	
	public List<OrdersPO> getOrderForm (Formstate state)throws RemoteException;
	
	public ResultMessage updateOrderForm (OrdersPO po)throws RemoteException;
	
	public long findLastID() throws RemoteException;
}
