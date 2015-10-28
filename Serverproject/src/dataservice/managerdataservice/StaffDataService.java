package dataservice.managerdataservice;

import java.rmi.RemoteException;

import po.StaffPO;

public interface StaffDataService {
	public void addStaff (StaffPO po)throws RemoteException;
	
	public void deleteStaff (StaffPO po)throws RemoteException;
	
	public void updateStaff (StaffPO po)throws RemoteException;
	
	public StaffPO  findStaff(long Staffid)throws RemoteException;

}
