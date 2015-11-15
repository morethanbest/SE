package businesslogicservice.managerblservice;

import java.rmi.RemoteException;

import vo.ResultMessage; 

import vo.StaffVO;

public interface StaffBlService {
	public ResultMessage addStaff(StaffVO vo)throws RemoteException;
	
	public ResultMessage delStaff(StaffVO vo)throws RemoteException;
	
	public ResultMessage revStaff(StaffVO vo)throws RemoteException;
	
	public StaffVO getStaff(String name)throws RemoteException;

}
