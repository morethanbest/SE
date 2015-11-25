package data.logisticsdata;

import dataservice.logisticsdataservice.ArrivalFormDataService;
import po.ArrivalPO;
import po.Formstate;
import po.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ArrivalFormData extends UnicastRemoteObject implements ArrivalFormDataService{

	public ArrivalFormData() throws  RemoteException{
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public List<ArrivalPO> getArrivalForm(Formstate state) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage updateArrivalForm(ArrivalPO po) throws RemoteException {
		return null;
	}

	@Override
	 public ResultMessage addArrivalForm(ArrivalPO po) throws RemoteException {
		return null;
	}

	@Override
		 public long findLastID() throws RemoteException {
		return 0;
	}
}
