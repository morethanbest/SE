package dataservice.commoditydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.CommodityLocation;
import po.Formstate;
import po.ResultMessage;
import po.StockinPO;

public interface StockinFormDataService extends Remote {
	public ResultMessage addStockinForm (StockinPO po)throws RemoteException;
	
	public List<StockinPO> getStockinForm (Formstate state,String orgcode)throws RemoteException;
	
	public ResultMessage updateStockinForm (StockinPO po)throws RemoteException;

	public CommodityLocation getLocation(String orgcode)throws RemoteException;		//得到一个空的位置

	public long getid(String orgcode)throws  RemoteException;
}
