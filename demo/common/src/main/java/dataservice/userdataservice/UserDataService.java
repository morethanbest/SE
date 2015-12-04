package dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.OrganizationPO;
import po.ResultMessage;
import po.UserPO;

public interface UserDataService extends Remote {
	public ResultMessage add(UserPO po)throws RemoteException;
	
	public ResultMessage delete (UserPO po)throws RemoteException;
	
	public UserPO find(String username)throws RemoteException;
	
	public ResultMessage update (UserPO po)throws RemoteException;
	
	public OrganizationPO getOrganization(String organizationcode)throws RemoteException;
}
