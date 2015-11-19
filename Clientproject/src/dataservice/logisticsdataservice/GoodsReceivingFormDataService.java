package dataservice.logisticsdataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.GoodsReceivingPO;
import vo.ResultMessage;

public interface GoodsReceivingFormDataService {
	public ResultMessage addGoodsReceivingForm (GoodsReceivingPO po)throws RemoteException;
	
	public List<GoodsReceivingPO> getGoodsReceivingForm (Formstate state)throws RemoteException;
	
	public ResultMessage updateGoodsReceivingForm (GoodsReceivingPO po)throws RemoteException;
	
	public long findLastID() throws RemoteException;
	
	
}
