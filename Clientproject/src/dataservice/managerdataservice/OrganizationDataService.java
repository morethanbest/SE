package dataservice.managerdataservice;

import java.rmi.RemoteException;

import po.OrganizationPO;

public interface OrganizationDataService {
	public void addOrganization (OrganizationPO po)throws RemoteException;
	
	public void deleteOrganization (OrganizationPO po)throws RemoteException;
	
	public void updateOrganization (OrganizationPO po)throws RemoteException;
	
	public OrganizationPO  findOrganization(String name)throws RemoteException;

}
