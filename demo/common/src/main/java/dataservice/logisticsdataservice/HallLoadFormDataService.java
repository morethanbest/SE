package dataservice.logisticsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.HallLoadPO;
import po.ResultMessage;

public interface HallLoadFormDataService extends Remote {
	public ResultMessage addLoadForm (HallLoadPO po)throws RemoteException;
	
	public List<HallLoadPO> getLoadForm (Formstate state,String orgcode)throws RemoteException;
	
	public ResultMessage updateLoadForm(HallLoadPO po)throws RemoteException;
	
	public long findLastmotorcode(String orgcode,String date) throws RemoteException;
	
	public double getunitprice(String transporttype)throws RemoteException;
	
	public double getdistance(String city1,String city2)throws RemoteException;
	
	public double getweight(String ordernum)throws RemoteException;
	
}
