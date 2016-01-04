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
	
	public List<GoodsReceivingPO> getGoodsReceivingForm (Formstate state,String orgcode)throws RemoteException;
	
	public ResultMessage updateGoodsReceivingForm (GoodsReceivingPO po)throws RemoteException;
	
	public long findLastID(String orgcode) throws RemoteException;
	
	public HallLoadPO getHallLoadBycode(String hallloadcode) throws  RemoteException;//这的hallloadcode即为 接收货物上的中转单编号  为营业厅的装车单编号
	
	public CenterloadPO getCenterLoadBycode(String centerloadcode) throws  RemoteException;//这里的centerloadcode即为 接收货物单据上的中转单编号   为中转中心的装车单编号
	
}
