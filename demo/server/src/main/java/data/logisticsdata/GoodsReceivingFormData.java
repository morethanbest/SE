package data.logisticsdata;

import dataservice.logisticsdataservice.GoodsReceivingFormDataService;
import po.Formstate;
import po.GoodsReceivingPO;
import po.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 */
public class GoodsReceivingFormData extends UnicastRemoteObject implements GoodsReceivingFormDataService{

	public GoodsReceivingFormData() throws  RemoteException{
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public ResultMessage addGoodsReceivingForm(GoodsReceivingPO po) throws RemoteException {
		return null;
	}

	@Override
	public List<GoodsReceivingPO> getGoodsReceivingForm(Formstate state) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage updateGoodsReceivingForm(GoodsReceivingPO po) throws RemoteException {
		return null;
	}

	@Override
	public long findLastID() throws RemoteException {
		return 0;
	}
}
