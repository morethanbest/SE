package data.commoditydata;

import dataservice.commoditydataservice.CommodityDataService;
import po.CommodityLocation;
import po.CommodityPO;
import po.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import data.database.CommodityDB.CommodityDB;

public class CommodityData extends UnicastRemoteObject implements CommodityDataService{

	public CommodityData() throws  RemoteException{
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public List<CommodityPO> getallCommodity(String orgcode) throws RemoteException {
		// TODO Auto-generated method stub
		return CommodityDB.getAll(orgcode);
	}

	@Override
	public ResultMessage addnew(CommodityPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return CommodityDB.write(po);
	}

	@Override
	public boolean wheOverLoad(String orgcode, long blocknum) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CommodityPO getCommodityByLocation(String orgcode, CommodityLocation location) throws RemoteException {
		// TODO Auto-generated method stub
		return CommodityDB.getbyLocation(orgcode, location);
	}

	@Override
	public ResultMessage updateCommodtiy(CommodityPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return CommodityDB.update(po);
	}

	@Override
	public CommodityPO getCommodityByCode(String orgcode, String ordercode) throws RemoteException {
		// TODO Auto-generated method stub
		return CommodityDB.getbyCode(orgcode, ordercode);
	}

	@Override
	public ResultMessage setOuttime(CommodityPO po, long endtime) throws RemoteException {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public long getStopPoint(String orgcode, long date) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CommodityPO> stockTaking(String orgcode, long date, long blocknum) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommodityPO> getCommodtiyByBlock(String orgcode, long blocknum) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Long> getAllBlock(String orgcode) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Long> getCommodityNumber(String orgcode, long begin, long end) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommodityPO> getCommodityBetween(String orgcode, long starttime, long endtime) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
