package data.managerdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import data.database.managerDB.StaffDB;
import dataservice.managerdataservice.StaffDataService;
import po.Job;
import po.ResultMessage;
import po.StaffPO;

public class StaffData extends UnicastRemoteObject implements StaffDataService {
	public  StaffData() throws  RemoteException{
		super();
	}
	@Override
	public ResultMessage addStaff(StaffPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(po!=null)
			return StaffDB.write(po);
		else 
			return ResultMessage.failure;
	}

	@Override
	public ResultMessage deleteStaff(StaffPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(po!=null)
			return StaffDB.delete(po.getId());
		else 
			return ResultMessage.failure;
	}

	@Override
	public ResultMessage updateStaff(StaffPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(po!=null)
			return StaffDB.update(po);
		else 
			return ResultMessage.failure;
	}
	

	@Override
	public StaffPO findStaff(long id) throws RemoteException {
		// TODO Auto-generated method stub
		StaffPO po=StaffDB.search(id);
		return po;
	}


	@Override
	public long getLastId() throws RemoteException {
		// TODO Auto-generated method stub
		long id=StaffDB.getLastId();
		return id;
	}

	@Override
	public List<StaffPO> fuzzyfindbyjob(Job job) throws RemoteException {
		// TODO Auto-generated method stub
		List<StaffPO> list=StaffDB.fuzzySearchbyjob(job);
		return list;
	}
	@Override
	public List<StaffPO> fuzzyfindbyorganization(String organizationame) throws RemoteException {
		// TODO Auto-generated method stub
		return StaffDB.fuzzySearchbyorganizationname(organizationame);
	}
	@Override
	public List<StaffPO> fuzzyfindbyboth(String organizationame, Job job) throws RemoteException {
		// TODO Auto-generated method stub
		return StaffDB.fuzzySearchbyboth(organizationame, job);
	}
	@Override
	public List<StaffPO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		return StaffDB.getAll();
	}




}
