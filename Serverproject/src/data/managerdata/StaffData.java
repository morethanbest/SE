package data.managerdata;

import java.rmi.RemoteException;

import data.database.StaffDB;
import dataservice.managerdataservice.StaffDataService;
import po.ResultMessage;
import po.StaffPO;

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
	public ResultMessage updateStaff(String originalname,StaffPO po) throws RemoteException {
		// TODO Auto-generated method stub
		ResultMessage result=StaffDB.update(originalname, po.getName(), po.getJob());
		return result;
	}
	
	@Override
	public StaffPO findStaff(String name) throws RemoteException {
		// TODO Auto-generated method stub
		StaffPO po=StaffDB.search(name);
		return po;
	}

	@Override
	public long getLastId() throws RemoteException {
		// TODO Auto-generated method stub
		long id=StaffDB.getLastId();
		return id;
	}


}
