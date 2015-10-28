package dataservice.managerdataservice;

import java.rmi.RemoteException;

import po.ConstantsPO;

public interface ConstantsDataService {
	public void addConstants (ConstantsPO po)throws RemoteException;
	
	public void deleteConstants (ConstantsPO po)throws RemoteException;

	public void updateConstants (ConstantsPO po)throws RemoteException;
	
	public ConstantsPO  findConstants(long id)throws RemoteException;
}
