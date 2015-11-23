package data.commoditydata;

import dataservice.commoditydataservice.CommodityDataService;
import po.CommodityLocation;
import po.CommodityPO;
import po.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class CommodityData extends UnicastRemoteObject implements CommodityDataService{

	public CommodityData() throws  RemoteException{
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public List<CommodityPO> getallCommodity() throws RemoteException {
		return null;
	}

	@Override
	public List<CommodityPO> getCommodityBetween(long starttime, long endtime) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage addnew(CommodityPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage setOuttime(CommodityPO po, long endtime) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage changeLocation(CommodityPO po, CommodityLocation location) throws RemoteException {
		return null;
	}
}
