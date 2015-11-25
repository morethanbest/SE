package dataservice.managerdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.Job;
import po.ResultMessage;
import po.StaffPO;

public interface StaffDataService extends Remote {
	public ResultMessage addStaff (StaffPO po)throws RemoteException;
	
	public ResultMessage deleteStaff (StaffPO po)throws RemoteException;
	
	public ResultMessage updateStaff (StaffPO po)throws RemoteException;
	
	public StaffPO  findStaff(long id)throws RemoteException;
	
	public List<StaffPO> fuzzyfindbyorganization(String organizationcode)throws RemoteException;
	
	public List<StaffPO> fuzzyfindbyjob(Job job)throws RemoteException;
	
	public List<StaffPO> fuzzyfindbyboth(String organizationcode,Job job)throws RemoteException;
	
	public long getLastId()throws RemoteException;
}
