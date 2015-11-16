package dataservice.logisticsdataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.GoodsReceivingPO;

public interface GoodsReceivingFormDataService {
	public void addGoodsReceivingForm (GoodsReceivingPO po)throws RemoteException;
	
	public List<GoodsReceivingPO> getGoodsReceivingForm (Formstate state)throws RemoteException;
	
	public void updateGoodsReceivingForm (GoodsReceivingPO po)throws RemoteException;
	
	public long findLastID() throws RemoteException;
	
	
}
