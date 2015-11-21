package dataservice.managerdataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.ConstantsPO;
import po.ResultMessage;

public interface ConstantsDataService {
	public ResultMessage addConstants (ConstantsPO po)throws RemoteException;
	
	public ResultMessage deleteConstants (ConstantsPO po)throws RemoteException;

	public ResultMessage updateConstants (String originalname,ConstantsPO po)throws RemoteException;
	
	public List<ConstantsPO>  fuzzyfindConstants(String name)throws RemoteException;
	
	public ConstantsPO findConstants(String name)throws RemoteException;
	
	public long getLastId() throws RemoteException;
}
