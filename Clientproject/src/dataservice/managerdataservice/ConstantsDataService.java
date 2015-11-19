package dataservice.managerdataservice;

import java.rmi.RemoteException;

import po.ConstantsPO;
import vo.ResultMessage;

public interface ConstantsDataService {
	public ResultMessage addConstants (ConstantsPO po)throws RemoteException;
	
	public ResultMessage deleteConstants (ConstantsPO po)throws RemoteException;

	public ResultMessage updateConstants (ConstantsPO po)throws RemoteException;
	
	public ConstantsPO  findConstants(String name)throws RemoteException;
}
