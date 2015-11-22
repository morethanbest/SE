package businesslogicservice.managerblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Organizationtype;
import vo.ResultMessage; 
import vo.OrganizationVO;

public interface OrganizationBlService {
	public ResultMessage addOrganization (OrganizationVO vo)throws RemoteException;
	
	public ResultMessage delOrganization(OrganizationVO vo)throws RemoteException;
	
	public ResultMessage revOrganization (OrganizationVO vo)throws RemoteException;
	
	public List<OrganizationVO> getOrganizationbyName(String name)throws RemoteException;

	public List<OrganizationVO> getOrganizationbyType(Organizationtype type)throws RemoteException;

	public List<OrganizationVO> getOrganizationbyBoth(String name, Organizationtype type) throws RemoteException;
}
