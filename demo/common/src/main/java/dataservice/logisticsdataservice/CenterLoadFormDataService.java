package dataservice.logisticsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.CenterloadPO;
import po.CityPO;
import po.Formstate;
import po.ResultMessage;

public interface CenterLoadFormDataService extends Remote {

	public List<CenterloadPO> getCenterLoadForm (Formstate state)throws RemoteException;
	
	public ResultMessage updateCenterLoadForm (CenterloadPO po)throws RemoteException;
	
	public ResultMessage addCenterLoadForm (CenterloadPO po)throws RemoteException;
	
	public long findLastmotorcode(String orgcode,String date) throws RemoteException;








	//to calculate the fee
	public double getunitprice(String transporttype)throws RemoteException;

	public double getdistance(String city1,String city2)throws RemoteException;

	public double getweight(String ordernum)throws RemoteException;
	
}
