package businesslogicservice.managerblservice;

import java.rmi.RemoteException;

import vo.ResultMessage; 

import vo.OrganizationVO;

public interface OrganizationBlService {
	public ResultMessage addOrganization (OrganizationVO vo)throws RemoteException;
	
	public ResultMessage delOrganization(OrganizationVO vo)throws RemoteException;
	
	public ResultMessage revOrganization (OrganizationVO vo)throws RemoteException;
	
	public OrganizationVO getOrganization (String name)throws RemoteException;

}
