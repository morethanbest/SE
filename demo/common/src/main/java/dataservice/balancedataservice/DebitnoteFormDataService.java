package dataservice.balancedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.DebitnotePO;
import po.Formstate;
import po.ResultMessage;

public interface DebitnoteFormDataService extends Remote {
	public List<DebitnotePO> getDebitnoteForm (Formstate state,String orgcode)throws RemoteException;
	
	public ResultMessage updateDebitnoteForm (DebitnotePO po)throws RemoteException;
	
	public ResultMessage addDebitnoteForm (DebitnotePO po)throws RemoteException;
	
	public long getlastID(String orgcode)throws RemoteException;
	
}
