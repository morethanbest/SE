package data.managerdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import data.database.managerDB.ConstantsDB;
import dataservice.managerdataservice.ConstantsDataService;
import po.ConstantsPO;
import po.ResultMessage;

public class ConstantsData extends UnicastRemoteObject implements ConstantsDataService {
	public ConstantsData() throws  RemoteException{
		super();
	}
	@Override
	public ResultMessage addConstants(ConstantsPO po) throws RemoteException {
		if(po!=null)
			return ConstantsDB.write(po.getName(), po.getValue());
		else 
			return ResultMessage.failure;
	}

	@Override
	public ResultMessage deleteConstants(ConstantsPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(po!=null)
			return ConstantsDB.delete(po.getId());
		else 
			return ResultMessage.failure;
	}

	@Override
	public ResultMessage updateConstants(ConstantsPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(po!=null)
			return ConstantsDB.update(po.getName(), po.getValue());
		else 
			return ResultMessage.failure;
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
