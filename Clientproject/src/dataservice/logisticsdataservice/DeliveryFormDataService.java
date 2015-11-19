package dataservice.logisticsdataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.DeliveryPO;
import po.Formstate;
import vo.ResultMessage;

public interface DeliveryFormDataService {
	public List<DeliveryPO> getDeliveryForm (Formstate state)throws RemoteException;
	
	public ResultMessage updateDeliveryForm (DeliveryPO po)throws RemoteException;
	
	public ResultMessage addDeliveryForm (DeliveryPO po)throws RemoteException;
	
	public long findLastID() throws RemoteException;
}
