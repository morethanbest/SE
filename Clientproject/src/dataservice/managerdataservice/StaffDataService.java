package dataservice.managerdataservice;

import java.rmi.RemoteException;

import po.StaffPO;
import vo.ResultMessage;

public interface StaffDataService {
	public ResultMessage addStaff (StaffPO po)throws RemoteException;
	
	public ResultMessage deleteStaff (StaffPO po)throws RemoteException;
	
	public ResultMessage updateStaff (String originalname,StaffPO po)throws RemoteException;
	
	public StaffPO  findStaff(String name)throws RemoteException;
	
	public long getLastId()throws RemoteException;
}
