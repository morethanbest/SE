package data.balancedata;

import dataservice.balancedataservice.DebitnoteFormDataService;
import po.CityPO;
import po.DebitnotePO;
import po.Formstate;
import po.OrganizationPO;
import po.RecordcollectPO;
import po.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class DebitnoteFormData extends UnicastRemoteObject implements DebitnoteFormDataService{

	public DebitnoteFormData() throws  RemoteException{
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public List<RecordcollectPO> getRecordcollectbyhall(String orgcode) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RecordcollectPO> getRecordcollectbydate(long date) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CityPO> getALLCity() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrganizationPO> getAllOrganization(String city) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
