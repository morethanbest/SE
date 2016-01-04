package dataservice.managerdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.ArrivalPO;
import po.CenterloadPO;
import po.DeliveryPO;
import po.Formstate;
import po.GoodsReceivingPO;
import po.HallLoadPO;
import po.OrderPO;
import po.RecordcollectPO;
import po.RecordpayPO;
import po.RecordtransPO;
import po.ResultMessage;
import po.StockinPO;
import po.StockoutPO;

//可以考虑分成多个dataserivce
public interface ExamDataService extends Remote{
	//exam order
	public List<OrderPO> getOrderForm (Formstate state)throws RemoteException;
	
	public ResultMessage updateOrderForm (OrderPO po)throws RemoteException;

	public OrderPO getpo(String ordercode) throws RemoteException;
	
	
	//exam Arrival
	public List<ArrivalPO> getArrivalForm (Formstate state)throws RemoteException;
	
	public ResultMessage updateArrivalForm (ArrivalPO po)throws RemoteException;
	
	
	//exam Centerload
	public List<CenterloadPO> getCenterLoadForm (Formstate state)throws RemoteException;
	
	public ResultMessage updateCenterLoadForm (CenterloadPO po)throws RemoteException;
	
	//exam delivery
	public List<DeliveryPO> getDeliveryForm (Formstate state)throws RemoteException;
	
	public ResultMessage updateDeliveryForm (DeliveryPO po)throws RemoteException;
	
	
	//exam GoodsReceiving
	public List<GoodsReceivingPO> getGoodsReceivingForm (Formstate state)throws RemoteException;
	
	public ResultMessage updateGoodsReceivingForm (GoodsReceivingPO po)throws RemoteException;
	
	//exam HallLoad
	public List<HallLoadPO> getLoadForm (Formstate state)throws RemoteException;
	
	public ResultMessage updateLoadForm(HallLoadPO po)throws RemoteException;
	
	//exam Recordtrans
	public List<RecordtransPO> getRecordtransForm (Formstate state)throws RemoteException;

	public ResultMessage updateRecordtransForm (RecordtransPO po)throws RemoteException;

	//exam recordcollect
	public List<RecordcollectPO> getRecordcollectForm (Formstate state)throws RemoteException;
	
	public ResultMessage updateRecordcollectForm (RecordcollectPO po)throws RemoteException;
	
	//exam Recordpay
	public List<RecordpayPO> getRecordpayForm (Formstate state)throws RemoteException;
	
	public ResultMessage updateRecordpayForm (RecordpayPO po)throws RemoteException;
	
	//exam stockin
	public List<StockinPO> getStockinForm (Formstate state)throws RemoteException;
	
	public ResultMessage updateStockinForm (StockinPO po)throws RemoteException;
	
	//exam stockout
	public List<StockoutPO> getStockoutForm (Formstate state)throws RemoteException;
	
	public ResultMessage updateStockoutForm (StockoutPO po)throws RemoteException;
}
