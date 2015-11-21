package dataservice.managerdataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Job;
import po.StaffPO;
import vo.ResultMessage;

public interface StaffDataService {
	public ResultMessage addStaff (StaffPO po)throws RemoteException;
	
	public ResultMessage deleteStaff (StaffPO po)throws RemoteException;
	
	public ResultMessage updateStaff (StaffPO po)throws RemoteException;
	
	public StaffPO  findStaff(long id)throws RemoteException;
	
	public List<StaffPO> fuzzyfindStaff(String name)throws RemoteException;
	
	public List<StaffPO> fuzzyfindbyjob(Job job)throws RemoteException;
	
	public List<StaffPO> fuzzyfindbyboth(String name,Job job)throws RemoteException;
	
	public long getLastId()throws RemoteException;
}
