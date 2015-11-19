package dataservice.balancedataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.DebitnotePO;
import po.Formstate;
import vo.ResultMessage;

public interface DebitnoteFormDataService {
	public List<DebitnotePO> getDebitnoteForm (Formstate state)throws RemoteException;
	
	public ResultMessage updateDebitnoteForm (DebitnotePO po)throws RemoteException;
	
	public ResultMessage addDebitnoteForm (DebitnotePO po)throws RemoteException;
	
}
