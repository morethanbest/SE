package dataservice.commoditydataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.CommodityLocation;
import po.CommodityPO;
import vo.ResultMessage;

public interface CommodityDataService {
	public List<CommodityPO> getallCommodity()throws RemoteException;
	
	public List<CommodityPO>  getCommodityBetween(long starttime,long endtime)throws RemoteException;

	public ResultMessage addnew(CommodityPO po) throws RemoteException;
	
	public ResultMessage setOuttime(CommodityPO po,long endtime) throws RemoteException;
	
	public ResultMessage changeLocation(CommodityPO po, CommodityLocation location)throws RemoteException;


}
