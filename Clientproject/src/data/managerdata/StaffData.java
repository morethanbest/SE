package data.managerdata;

import java.rmi.RemoteException;
import java.util.List;

import data.database.StaffDB;
import dataservice.managerdataservice.StaffDataService;
import po.Job;
import po.StaffPO;
import vo.ResultMessage;

public class StaffData implements StaffDataService {

	@Override
	public ResultMessage addStaff(StaffPO po) throws RemoteException {
		// TODO Auto-generated method stub
		ResultMessage result=StaffDB.write(po.getName(), po.getJob());
		return result;
	}

	@Override
	public ResultMessage deleteStaff(StaffPO po) throws RemoteException {
		// TODO Auto-generated method stub
		ResultMessage result=StaffDB.delete(po.getId());
		return result;
	}

	@Override
	public ResultMessage updateStaff(StaffPO po) throws RemoteException {
		// TODO Auto-generated method stub
		ResultMessage result=StaffDB.update(po.getId(),po.getName(), po.getJob());
		return result;
	}
	

	@Override
	public StaffPO findStaff(long id) throws RemoteException {
		// TODO Auto-generated method stub
		StaffPO po=StaffDB.search(id);
		return po;
	}

	@Override
	public List<StaffPO> fuzzyfindStaff(String name) throws RemoteException {
		// TODO Auto-generated method stub
		List<StaffPO> list=StaffDB.fuzzySearch(name);
		return list;
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
	public List<StaffPO> fuzzyfindbyboth(String name, Job job) throws RemoteException {
		// TODO Auto-generated method stub
		List<StaffPO> list=StaffDB.fuzzySearchbyboth(name, job);
		return list;
	}


}
