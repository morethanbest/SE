package dataservice.logisticsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.CenterloadPO;
import po.Formstate;
import po.GoodsReceivingPO;
import po.HallLoadPO;
import po.ResultMessage;

public interface GoodsReceivingFormDataService extends Remote {
	public ResultMessage addGoodsReceivingForm (GoodsReceivingPO po)throws RemoteException;
	
	public List<GoodsReceivingPO> getGoodsReceivingForm (Formstate state)throws RemoteException;
	
	public ResultMessage updateGoodsReceivingForm (GoodsReceivingPO po)throws RemoteException;
	
	public long findLastID() throws RemoteException;
	
	public HallLoadPO getHallLoadBycode(String hallloadcode) throws  RemoteException;
	
	public CenterloadPO getCenterLoadBycode(String centerloadcode) throws  RemoteException;
	
}
