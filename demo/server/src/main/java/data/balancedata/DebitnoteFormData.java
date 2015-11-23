package data.balancedata;

import dataservice.balancedataservice.DebitnoteFormDataService;
import po.DebitnotePO;
import po.Formstate;
import po.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class DebitnoteFormData extends UnicastRemoteObject implements DebitnoteFormDataService{

	public DebitnoteFormData() throws  RemoteException{
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public List<DebitnotePO> getDebitnoteForm(Formstate state) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage updateDebitnoteForm(DebitnotePO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage addDebitnoteForm(DebitnotePO po) throws RemoteException {
		return null;
	}
}
