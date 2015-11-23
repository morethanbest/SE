package data.managerdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import data.database.OrganizationDB;
import dataservice.managerdataservice.OrganizationDataService;
import po.OrganizationPO;
import po.Organizationtype;
import po.ResultMessage;

public class OrganizationData extends UnicastRemoteObject implements OrganizationDataService {
	public OrganizationData() throws  RemoteException{
		super();
	}
	@Override
	public ResultMessage addOrganization(OrganizationPO po) throws RemoteException {
		// TODO Auto-generated method stub
		ResultMessage result=OrganizationDB.update(po.getId(), po.getName(), po.getType());
		return result;
	}

	@Override
	public ResultMessage deleteOrganization(OrganizationPO po) throws RemoteException {
		// TODO Auto-generated method stub
		ResultMessage result=OrganizationDB.delete(po.getId());
		return result;
	}

	@Override
	public ResultMessage updateOrganization(OrganizationPO po) throws RemoteException {
		// TODO Auto-generated method stub
		ResultMessage result=OrganizationDB.update(po.getId(), po.getName(), po.getType());
		return result;
	}

	@Override
	public OrganizationPO findOrganization(long id) throws RemoteException {
		// TODO Auto-generated method stub
		OrganizationPO po=OrganizationDB.search(id);
		return po;
	}

	@Override
	public List<OrganizationPO> fuzzyfind(String name) throws RemoteException {
		// TODO Auto-generated method stub	
		List<OrganizationPO> list =OrganizationDB.fuzzySearch(name);
		return list;
	}

	@Override
	public List<OrganizationPO> fuzzyfindbytype(Organizationtype type) throws RemoteException {
		// TODO Auto-generated method stub
		List<OrganizationPO> list =OrganizationDB.fuzzySearchbytype(type);
		return list;
	}

	@Override
	public List<OrganizationPO> fuzzyfindbyboth(String name, Organizationtype type) throws RemoteException {
		// TODO Auto-generated method stub
		List<OrganizationPO> list =OrganizationDB.fuzzySearchbyboth(name,type);
		return list;
	}

	@Override
	public long getLastId() throws RemoteException {
		// TODO Auto-generated method stub
		long id = OrganizationDB.getLastId();
		return id;
	}

}
