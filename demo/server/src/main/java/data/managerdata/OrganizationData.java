package data.managerdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import data.database.managerDB.OrganizationDB;
import dataservice.managerdataservice.OrganizationDataService;
import po.City;
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
		ResultMessage result=OrganizationDB.update( po.getName(),po.getOrganizationcode(), po.getType(),po.getCity());
		return result;
	}

	@Override
	public List<OrganizationPO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		return OrganizationDB.getAll();
	}
	@Override
	public ResultMessage deleteOrganization(OrganizationPO po) throws RemoteException {
		// TODO Auto-generated method stub
		ResultMessage result=OrganizationDB.delete(po.getOrganizationcode());
		return result;
	}

	@Override
	public ResultMessage updateOrganization(OrganizationPO po) throws RemoteException {
		// TODO Auto-generated method stub
		ResultMessage result=OrganizationDB.update(po.getName(),po.getOrganizationcode(), po.getType(),po.getCity());
		return result;
	}


	@Override
	public List<OrganizationPO> fuzzyfind(City city) throws RemoteException {
		// TODO Auto-generated method stub	
		List<OrganizationPO> list =OrganizationDB.fuzzySearchbycity(city);
		return list;
	}

	@Override
	public List<OrganizationPO> fuzzyfindbytype(Organizationtype type) throws RemoteException {
		// TODO Auto-generated method stub
		List<OrganizationPO> list =OrganizationDB.fuzzySearchbytype(type);
		return list;
	}

	@Override
	public List<OrganizationPO> fuzzyfindbyboth(City city, Organizationtype type) throws RemoteException {
		// TODO Auto-generated method stub
		List<OrganizationPO> list =OrganizationDB.fuzzySearchbyboth(city,type);
		return list;
	}

	@Override
	public 	String getlasthallcode(City city) throws RemoteException {
		// TODO Auto-generated method stub
		String hallcode = OrganizationDB.gethallcode(city);
		return hallcode;
	}

}
