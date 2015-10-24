package dataservice.logisticsdataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.DeliveryPO;
import po.Formstate;

public interface DeliveryFormDataService {
	public List<DeliveryPO> getDeliveryForm (Formstate state)throws RemoteException;
	
	public void updateDeliveryForm (DeliveryPO po)throws RemoteException;
	
	public void addDeliveryForm (DeliveryPO po)throws RemoteException;
	
}
