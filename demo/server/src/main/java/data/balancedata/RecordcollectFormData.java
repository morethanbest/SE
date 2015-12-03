package data.balancedata;

import dataservice.balancedataservice.RecordcollectFormDataService;
import po.Formstate;
import po.RecordcollectPO;
import po.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RecordcollectFormData extends UnicastRemoteObject implements RecordcollectFormDataService{

	public RecordcollectFormData() throws RemoteException{
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public ResultMessage addRecordcollectForm(RecordcollectPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RecordcollectPO> getRecordcollectForm(Formstate state, String orgcode) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage updateRecordcollectForm(RecordcollectPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getlastid(String orgcode) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultMessage addmoney(String accountname, double fee) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
