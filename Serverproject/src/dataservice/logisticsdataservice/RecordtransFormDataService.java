package dataservice.logisticsdataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.RecordtransPO;
import po.ResultMessage;

public interface RecordtransFormDataService {
	public List<RecordtransPO> getRecordtransForm (Formstate state)throws RemoteException;
	
	public ResultMessage updateRecordtransForm (RecordtransPO po)throws RemoteException;
	
	public ResultMessage addRecordtransForm (RecordtransPO po)throws RemoteException;
	
	public long findLastID() throws RemoteException;
	
	public RecordtransPO getRecordtransForm (String transNumber)throws RemoteException;
}
