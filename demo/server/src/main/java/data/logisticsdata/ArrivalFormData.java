package data.logisticsdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import data.database.logisticsDB.ArrivalDB;
import dataservice.logisticsdataservice.ArrivalFormDataService;
import po.ArrivalPO;
import po.Formstate;
import po.HallLoadPO;
import po.RecordtransPO;
import po.ResultMessage;

public class ArrivalFormData extends UnicastRemoteObject implements ArrivalFormDataService{

	public ArrivalFormData() throws  RemoteException{
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public List<ArrivalPO> getArrivalForm(Formstate state) throws RemoteException {
		return ArrivalDB.fuzzySearch(state);
	}

	@Override
	public ResultMessage updateArrivalForm(ArrivalPO po) throws RemoteException {
		return ArrivalDB.update(po);
	}

	@Override
	 public ResultMessage addArrivalForm(ArrivalPO po) throws RemoteException {
		return ArrivalDB.write(po);
	}

	@Override
	public HallLoadPO getHallLoadBycode(String hallloadcode) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RecordtransPO getRecordtransBycode(String recordtranscode) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long findLastID() throws RemoteException {
		return ArrivalDB.getLastId();
	}
}
