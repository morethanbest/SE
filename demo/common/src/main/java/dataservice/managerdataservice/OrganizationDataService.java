package dataservice.managerdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.City;
import po.OrganizationPO;
import po.Organizationtype;
import po.ResultMessage;

public interface OrganizationDataService extends Remote {
	public ResultMessage addOrganization (OrganizationPO po)throws RemoteException;
	
	public ResultMessage deleteOrganization (OrganizationPO po)throws RemoteException;
	
	public ResultMessage updateOrganization (OrganizationPO po)throws RemoteException;
	
	public List<OrganizationPO> fuzzyfind(City city)throws RemoteException;
	
	public List<OrganizationPO> fuzzyfindbytype(Organizationtype type)throws RemoteException;
	
	public List<OrganizationPO> fuzzyfindbyboth(City city,Organizationtype type)throws RemoteException;
	
	public String getlasthallcode(City city)throws RemoteException;

}
