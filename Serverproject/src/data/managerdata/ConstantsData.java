package data.managerdata;

import java.rmi.RemoteException;
import java.util.List;

import data.database.ConstantsDB;
import dataservice.managerdataservice.ConstantsDataService;
import po.ConstantsPO;
import po.ResultMessage;

public class ConstantsData implements ConstantsDataService {

	@Override
	public ResultMessage addConstants(ConstantsPO po) throws RemoteException {
		ResultMessage result=ConstantsDB.write(po.getName(), po.getValue());
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public ResultMessage deleteConstants(ConstantsPO po) throws RemoteException {
		// TODO Auto-generated method stub
		ResultMessage result=ConstantsDB.delete(po.getId());
		return result;
	}

	@Override
	public ResultMessage updateConstants(String originalname,ConstantsPO po) throws RemoteException {
		// TODO Auto-generated method stub
		ResultMessage result=ConstantsDB.update(originalname, po.getName(), po.getValue());
		return result;
	}

	@Override
	public List<ConstantsPO> fuzzyfindConstants(String name) throws RemoteException {
		// TODO Auto-generated method stub
		List<ConstantsPO> list=ConstantsDB.fuzzySearch(name);
		return list;
	}

	@Override
	public ConstantsPO findConstants(String name) throws RemoteException {
		// TODO Auto-generated method stub
		ConstantsPO po=ConstantsDB.search(name);
		return po;
	}

	@Override
	public long getLastId() throws RemoteException {
		// TODO Auto-generated method stub
		long lastId=ConstantsDB.getLastId();
		return lastId;
	}

}
