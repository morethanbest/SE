package data.managerdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import data.database.balanceDB.RecordcollectDB;
import data.database.balanceDB.RecordpayDB;
import data.database.commodityDB.StockinDB;
import data.database.commodityDB.StockoutDB;
import data.database.logisticsDB.ArrivalDB;
import data.database.logisticsDB.CenterloadDB;
import data.database.logisticsDB.DeliveryDB;
import data.database.logisticsDB.GoodsReceivingDB;
import data.database.logisticsDB.HallLoadDB;
import data.database.logisticsDB.RecordtransDB;
import data.database.orderDB.OrderDB;
import dataservice.managerdataservice.ExamDataService;
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

public class ExamData extends UnicastRemoteObject implements ExamDataService {

	public ExamData() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<OrderPO> getOrderForm(Formstate state) throws RemoteException {
		// TODO Auto-generated method stub
		return OrderDB.fuzzySearch(state);
	}

	@Override
	public ResultMessage updateOrderForm(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(po!=null)
			return OrderDB.update(po);
		else 
			return ResultMessage.failure;
	}

	@Override
	public OrderPO getpo(String ordercode) throws RemoteException {
		// TODO Auto-generated method stub
		return OrderDB.search(ordercode);
	}

	@Override
	public List<ArrivalPO> getArrivalForm(Formstate state) throws RemoteException {
		// TODO Auto-generated method stub
		return ArrivalDB.fuzzySearch(state);
	}

	@Override
	public ResultMessage updateArrivalForm(ArrivalPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(po!=null)
			return ArrivalDB.update(po);
		else 
			return ResultMessage.failure;
		
	}

	@Override
	public List<CenterloadPO> getCenterLoadForm(Formstate state) throws RemoteException {
		// TODO Auto-generated method stub
		return CenterloadDB.fuzzySearch(state);
	}

	@Override
	public ResultMessage updateCenterLoadForm(CenterloadPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(po!=null)
			return CenterloadDB.update(po);
		else 
			return ResultMessage.failure;
		
	}

	@Override
	public List<DeliveryPO> getDeliveryForm(Formstate state) throws RemoteException {
		// TODO Auto-generated method stub
		return DeliveryDB.fuzzySearch(state);
	}

	@Override
	public ResultMessage updateDeliveryForm(DeliveryPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(po!=null)
			return DeliveryDB.update(po);
		else 
			return ResultMessage.failure;
	
	}

	@Override
	public List<GoodsReceivingPO> getGoodsReceivingForm(Formstate state) throws RemoteException {
		// TODO Auto-generated method stub
		return GoodsReceivingDB.fuzzySearch(state);
	}

	@Override
	public ResultMessage updateGoodsReceivingForm(GoodsReceivingPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(po!=null)
			return GoodsReceivingDB.update(po);
		else 
			return ResultMessage.failure;
		
	}

	@Override
	public List<HallLoadPO> getLoadForm(Formstate state) throws RemoteException {
		// TODO Auto-generated method stub
		return HallLoadDB.fuzzySearch(state);
	}

	@Override
	public ResultMessage updateLoadForm(HallLoadPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(po!=null)
			return HallLoadDB.update(po);
		else 
			return ResultMessage.failure;
		
	}

	@Override
	public List<RecordtransPO> getRecordtransForm(Formstate state) throws RemoteException {
		// TODO Auto-generated method stub
		return RecordtransDB.fuzzySearch(state);
	}

	@Override
	public ResultMessage updateRecordtransForm(RecordtransPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(po!=null)
			return RecordtransDB.update(po);
		else 
			return ResultMessage.failure;
		
	}

	@Override
	public List<RecordcollectPO> getRecordcollectForm(Formstate state) throws RemoteException {
		// TODO Auto-generated method stub
		return RecordcollectDB.fuzzySearch(state);
	}

	@Override
	public ResultMessage updateRecordcollectForm(RecordcollectPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(po!=null)
			return RecordcollectDB.update(po);
		else 
			return ResultMessage.failure;
		
	}

	@Override
	public List<RecordpayPO> getRecordpayForm(Formstate state) throws RemoteException {
		// TODO Auto-generated method stub
		return RecordpayDB.fuzzySearch(state);
	}

	@Override
	public ResultMessage updateRecordpayForm(RecordpayPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(po!=null)
			return RecordpayDB.update(po);
		else 
			return ResultMessage.failure;
		
	}

	@Override
	public List<StockinPO> getStockinForm(Formstate state) throws RemoteException {
		// TODO Auto-generated method stub
		return StockinDB.fuzzySearch(state);
	}

	@Override
	public ResultMessage updateStockinForm(StockinPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(po!=null)
			return StockinDB.update(po);
		else 
			return ResultMessage.failure;
		
	}

	@Override
	public List<StockoutPO> getStockoutForm(Formstate state) throws RemoteException {
		// TODO Auto-generated method stub
		return StockoutDB.fuzzySearch(state);
	}

	@Override
	public ResultMessage updateStockoutForm(StockoutPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(po!=null)
			return StockoutDB.update(po);
		else 
			return ResultMessage.failure;
		
	}

}
