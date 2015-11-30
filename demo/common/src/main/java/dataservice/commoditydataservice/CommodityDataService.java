package dataservice.commoditydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.CommodityLocation;
import po.CommodityPO;
import po.ResultMessage;

public interface CommodityDataService extends Remote {
	public List<CommodityPO> getallCommodity()throws RemoteException;
	
	public List<CommodityPO>  getCommodityBetween(long starttime,long endtime)throws RemoteException;

	public ResultMessage addnew(CommodityPO po) throws RemoteException;
	
	public ResultMessage setOuttime(CommodityPO po,long endtime) throws RemoteException;
	
	public ResultMessage changeLocation(CommodityPO po, CommodityLocation location)throws RemoteException;

	public long getnewid(String orgcode) throws  RemoteException;


}
