package data.logisticsdata;

import dataservice.logisticsdataservice.RecordtransFormDataService;
import po.Formstate;
import po.RecordtransPO;
import po.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RecordtransFormData extends UnicastRemoteObject implements RecordtransFormDataService{

	public RecordtransFormData() throws  RemoteException{
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public List<RecordtransPO> getRecordtransForm(Formstate state) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage updateRecordtransForm(RecordtransPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage addRecordtransForm(RecordtransPO po) throws RemoteException {
		return null;
	}

	@Override
	public long findLastID() throws RemoteException {
		return 0;
	}

	@Override
	public RecordtransPO getRecordtransForm(String transNumber) throws RemoteException {
		return null;
	}
}
