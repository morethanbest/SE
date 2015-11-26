package dataservice.logisticsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.ArrivalPO;
import po.Formstate;
import po.ResultMessage;

public interface ArrivalFormDataService extends Remote {
	public List<ArrivalPO> getArrivalForm (Formstate state)throws RemoteException;
	
	public ResultMessage updateArrivalForm (ArrivalPO po)throws RemoteException;
	
	public ResultMessage addArrivalForm (ArrivalPO po) throws RemoteException;
	
	public long findLastID(String centercode) throws RemoteException;

	public String getDepartureByTrans(String transcode) throws  RemoteException;
	public String getDepartureByLoad(String loadcode) throws  RemoteException;


}
