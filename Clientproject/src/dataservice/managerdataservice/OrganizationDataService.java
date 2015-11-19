package dataservice.managerdataservice;

import java.rmi.RemoteException;

import po.OrganizationPO;
import vo.ResultMessage;

public interface OrganizationDataService {
	public ResultMessage addOrganization (OrganizationPO po)throws RemoteException;
	
	public ResultMessage deleteOrganization (OrganizationPO po)throws RemoteException;
	
	public ResultMessage updateOrganization (OrganizationPO po)throws RemoteException;
	
	public OrganizationPO  findOrganization(String name)throws RemoteException;

}
