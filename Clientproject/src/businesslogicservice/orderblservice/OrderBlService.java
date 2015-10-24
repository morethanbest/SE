package businesslogicservice.orderblservice;

import java.rmi.RemoteException;

import vo.ResultMessage; 

import vo.OrderVO;

import vo.OrderFareVO;

import vo.ReceptionVO;

public interface OrderBlService {
	public ResultMessage order(OrderVO vo)throws RemoteException;
	
	public double order(OrderFareVO vo)throws RemoteException;
	
	public ResultMessage reception (ReceptionVO vo)throws RemoteException;

}
