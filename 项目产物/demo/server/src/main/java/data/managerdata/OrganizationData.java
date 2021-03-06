package data.managerdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import data.database.managerDB.OrganizationDB;
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
		if(po!=null)
			return OrganizationDB.write(po);
		else 
			return ResultMessage.failure;
	}

	@Override
	public List<OrganizationPO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		return OrganizationDB.getAll();
	}
	@Override
	public ResultMessage deleteOrganization(OrganizationPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(po!=null)
			return OrganizationDB.delete(po);
		else 
			return ResultMessage.failure;
		
	}

	@Override
	public ResultMessage updateOrganization(OrganizationPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(po!=null)
			return OrganizationDB.update(po);
		else 
			return ResultMessage.failure;
	}


	@Override
	public List<OrganizationPO> fuzzyfind(String city) throws RemoteException {
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
	public List<OrganizationPO> fuzzyfindbyboth(String city, Organizationtype type) throws RemoteException {
		// TODO Auto-generated method stub
		List<OrganizationPO> list =OrganizationDB.fuzzySearchbyboth(city,type);
		return list;
	}

	@Override
	public 	long getlasthallcode(String city) throws RemoteException {
		// TODO Auto-generated method stub
		return OrganizationDB.gethallcode(city);
	}
//	public static void main(String[] args){
//		try{
//		OrganizationData data=new OrganizationData();
//		if(data.addOrganization(new OrganizationPO("南京中转中心","0250",Organizationtype.transfercenter,"南京"))==ResultMessage.success)
//			System.out.println("add success");
//		
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
}
