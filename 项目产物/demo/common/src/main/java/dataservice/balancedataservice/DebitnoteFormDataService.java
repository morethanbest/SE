package dataservice.balancedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.CityPO;
import po.OrganizationPO;
import po.RecordcollectPO;

public interface DebitnoteFormDataService extends Remote {
		
	public List<RecordcollectPO> getRecordcollectbyhall(String orgcode)throws RemoteException;
	
	public List<RecordcollectPO> getRecordcollectbydate(long date)throws RemoteException;
	
	public List<CityPO> getALLCity()throws RemoteException;
	
	public List<OrganizationPO> getAllOrganization(String city)throws RemoteException;
	
	
}
