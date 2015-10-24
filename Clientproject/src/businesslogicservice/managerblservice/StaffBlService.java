package businesslogicservice.managerblservice;

import java.rmi.RemoteException;

import vo.ResultMessage; 

import vo.StaffVO;

public interface StaffBlService {
	public ResultMessage addStaff(StaffVO vo)throws RemoteException;
	
	public StaffVO delStaff()throws RemoteException;
	
	public ResultMessage revStaff(StaffVO vo)throws RemoteException;
	
	public ResultMessage getStaff(String name)throws RemoteException;

}
