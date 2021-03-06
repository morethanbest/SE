package data.logisticsdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import data.database.logisticsDB.ArrivalDB;
import data.database.logisticsDB.HallLoadDB;
import data.database.logisticsDB.RecordtransDB;
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
	public List<ArrivalPO> getArrivalForm(Formstate state,String orgcode) throws RemoteException {
		return ArrivalDB.fuzzySearch(state,orgcode);
	}

	@Override
	public ResultMessage updateArrivalForm(ArrivalPO po) throws RemoteException {
		if(po!=null)
			return ArrivalDB.update(po);
		else
			return ResultMessage.failure;
	}

	@Override
	 public ResultMessage addArrivalForm(ArrivalPO po) throws RemoteException {
		if(po!=null)
			return ArrivalDB.write(po);
		else
			return ResultMessage.failure;
		
	}

	@Override
	public HallLoadPO getHallLoadBycode(String hallloadcode) throws RemoteException {
		// TODO Auto-generated method stub
		return HallLoadDB.getpoBymotorcode(hallloadcode);
	}

	@Override
	public RecordtransPO getRecordtransBycode(String recordtranscode) throws RemoteException {
		// TODO Auto-generated method stub
		return RecordtransDB.getpoBytranscode(recordtranscode);
	}

	@Override
	public long findLastID(String orgcode) throws RemoteException {
		// TODO Auto-generated method stub
		return ArrivalDB.getLastId(orgcode);
	}


}
