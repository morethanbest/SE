package data.orderdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import data.database.orderDB.OrderDB;
import dataservice.orderdataservice.OrderFormDataService;
import po.Formstate;
import po.OrderPO;
import po.ResultMessage;

public class OrderFormData extends UnicastRemoteObject implements OrderFormDataService {
	public OrderFormData() throws  RemoteException{
		super();
	}
	@Override
	public ResultMessage addOrderForm(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
		
		return OrderDB.write(po);
	}

	@Override
	public OrderPO getOrderForm(String ordernum) throws RemoteException {
		// TODO Auto-generated method stub
		
		return OrderDB.search(ordernum);
	}

	@Override
	public List<OrderPO> getOrderForm(Formstate state,String orgcode) throws RemoteException {
		// TODO Auto-generated method stub
		return OrderDB.fuzzySearch(state,orgcode);
	}

	@Override
	public ResultMessage updateOrderForm(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return OrderDB.update(po);
	}

	@Override
	public long findLastID(String orgcode) throws RemoteException {
		// TODO Auto-generated method stub
		return OrderDB.getLastId(orgcode);
	}

}
