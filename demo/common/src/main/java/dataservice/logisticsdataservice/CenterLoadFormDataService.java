package dataservice.logisticsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.CenterloadPO;
import po.Formstate;
import po.ResultMessage;

public interface CenterLoadFormDataService extends Remote {
	public List<CenterloadPO> getCenterLoadForm (Formstate state)throws RemoteException;
	
	public ResultMessage updateCenterLoadForm (CenterloadPO po)throws RemoteException;
	
	public ResultMessage addCenterLoadForm (CenterloadPO po)throws RemoteException;
	
	public String findLastmotorcode(String orgcode) throws RemoteException;
}
