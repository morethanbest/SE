package dataservice.commoditydataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.CommodityLocation;
import po.CommodityPO;

public interface CommodityDataService {
	public List<CommodityPO> getallCommodity()throws RemoteException;
	
	public List<CommodityPO>  getCommodityBetween(long starttime,long endtime)throws RemoteException;

	public void addnew(CommodityPO po) throws RemoteException;
	
	public void setOuttime(CommodityPO po,long endtime) throws RemoteException;
	
	public void changeLocation(CommodityPO po, CommodityLocation location)throws RemoteException;


}
