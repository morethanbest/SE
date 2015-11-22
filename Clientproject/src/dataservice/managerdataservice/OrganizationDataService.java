package dataservice.managerdataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.OrganizationPO;
import po.Organizationtype;
import vo.ResultMessage;

public interface OrganizationDataService {
	public ResultMessage addOrganization (OrganizationPO po)throws RemoteException;
	
	public ResultMessage deleteOrganization (OrganizationPO po)throws RemoteException;
	
	public ResultMessage updateOrganization (OrganizationPO po)throws RemoteException;
	
	public OrganizationPO  findOrganization(long id)throws RemoteException;
	
	public List<OrganizationPO> fuzzyfind(String name)throws RemoteException;
	
	public List<OrganizationPO> fuzzyfindbytype(Organizationtype type)throws RemoteException;
	
	public List<OrganizationPO> fuzzyfindbyboth(String name,Organizationtype type)throws RemoteException;
	
	public long getLastId()throws RemoteException;

}
