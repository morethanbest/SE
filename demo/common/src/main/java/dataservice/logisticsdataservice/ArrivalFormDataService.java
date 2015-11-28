package dataservice.logisticsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.ArrivalPO;
import po.Formstate;
import po.HallLoadPO;
import po.RecordtransPO;
import po.ResultMessage;

public interface ArrivalFormDataService extends Remote {
	public List<ArrivalPO> getArrivalForm (Formstate state)throws RemoteException;
	
	public ResultMessage updateArrivalForm (ArrivalPO po)throws RemoteException;
	
	public ResultMessage addArrivalForm (ArrivalPO po) throws RemoteException;
	
	public long findLastID(String orgcode) throws RemoteException;

	public HallLoadPO getHallLoadBycode(String hallloadcode) throws  RemoteException;//根据中转单编号  得到中转中心的PO
	
	public RecordtransPO getRecordtransBycode(String recordtranscode) throws  RemoteException;//




}
