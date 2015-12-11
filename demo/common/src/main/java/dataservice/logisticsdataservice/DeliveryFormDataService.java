package dataservice.logisticsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.DeliveryPO;
import po.Formstate;
import po.ResultMessage;

public interface DeliveryFormDataService extends Remote {
	public List<DeliveryPO> getDeliveryForm (Formstate state,String orgcode)throws RemoteException;
	
	public ResultMessage updateDeliveryForm (DeliveryPO po)throws RemoteException;
	
	public ResultMessage addDeliveryForm (DeliveryPO po)throws RemoteException;
	
	public long findLastID(String orgcode) throws RemoteException;


}
