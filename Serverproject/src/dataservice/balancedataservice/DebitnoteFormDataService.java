package dataservice.balancedataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.DebitnotePO;
import po.Formstate;

public interface DebitnoteFormDataService {
	public List<DebitnotePO> getDebitnoteForm (Formstate state)throws RemoteException;
	
	public void updateDebitnoteForm (DebitnotePO po)throws RemoteException;
	
	public void addDebitnoteForm (DebitnotePO po)throws RemoteException;
	
}
