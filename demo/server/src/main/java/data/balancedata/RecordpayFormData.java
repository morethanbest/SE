package data.balancedata;

import dataservice.balancedataservice.RecordpayFormDataService;
import po.Formstate;
import po.RecordpayPO;
import po.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RecordpayFormData extends UnicastRemoteObject implements RecordpayFormDataService{

	public RecordpayFormData() throws  RemoteException{
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public List<RecordpayPO> getRecordpayForm(Formstate state) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage updateRecordpayForm(RecordpayPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage addRecordpayForm(RecordpayPO po) throws RemoteException {
		return null;
	}

	@Override
	public List<RecordpayPO> getallRecordpayForm() throws RemoteException {
		return null;
	}
}
