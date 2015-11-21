package businesslogicservice.managerblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Job;
import vo.ResultMessage; 
import vo.StaffVO;

public interface StaffBlService {
	public ResultMessage addStaff(StaffVO vo)throws RemoteException;
	
	public ResultMessage delStaff(StaffVO vo)throws RemoteException;
	
	public ResultMessage revStaff(StaffVO vo)throws RemoteException;
	
	public List<StaffVO> getStaffbyName(String name)throws RemoteException;
	
	public List<StaffVO> getStaffbyJob(Job job) throws RemoteException;
	
	public List<StaffVO> getStaffbyBoth(String name, Job job) throws RemoteException;

}
