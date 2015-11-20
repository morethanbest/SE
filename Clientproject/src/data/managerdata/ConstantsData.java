package data.managerdata;

import java.rmi.RemoteException;
import java.util.List;

import data.database.ConstantsDB;
import dataservice.managerdataservice.ConstantsDataService;
import po.ConstantsPO;
import vo.ResultMessage;

public class ConstantsData implements ConstantsDataService {

	@Override
	public ResultMessage addConstants(ConstantsPO po) throws RemoteException {
		ConstantsDB db=new ConstantsDB();
		ResultMessage result=db.write(po.getName(), po.getValue());
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public ResultMessage deleteConstants(ConstantsPO po) throws RemoteException {
		// TODO Auto-generated method stub
		ConstantsDB db=new ConstantsDB();
		ResultMessage result=db.delete(po.getId());
		return result;
	}

	@Override
	public ResultMessage updateConstants(String originalname,ConstantsPO po) throws RemoteException {
		// TODO Auto-generated method stub
		ConstantsDB db=new ConstantsDB();
		ResultMessage result=db.update(originalname, po.getName(), po.getValue());
		return result;
	}

	@Override
	public List<ConstantsPO> fuzzyfindConstants(String name) throws RemoteException {
		// TODO Auto-generated method stub
		ConstantsDB db=new ConstantsDB();
		List<ConstantsPO> list=db.fuzzySearch(name);
		return list;
	}

	@Override
	public ConstantsPO findConstants(String name) throws RemoteException {
		// TODO Auto-generated method stub
		ConstantsDB db=new ConstantsDB();
		ConstantsPO po=db.search(name);
		return po;
	}

	@Override
	public long getLastId() throws RemoteException {
		// TODO Auto-generated method stub
		ConstantsDB db=new ConstantsDB();
		long lastId=db.getLastId();
		return lastId;
	}

}
