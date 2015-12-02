package dataservice.logisticsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.RecordtransPO;
import po.ResultMessage;

public interface RecordtransFormDataService extends Remote {
	public List<RecordtransPO> getRecordtransForm (Formstate state,String orgcode)throws RemoteException;

	public ResultMessage updateRecordtransForm (RecordtransPO po)throws RemoteException;

	public ResultMessage addRecordtransForm (RecordtransPO po)throws RemoteException;

	public long  findLasttranscode(String orgcode,long date) throws RemoteException;

	public double getunitprice(String transporttype)throws RemoteException;

	public double getdistance(String city1,String city2)throws RemoteException;

	public double getweight(String ordernum)throws RemoteException;
	

}
