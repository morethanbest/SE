package data.logisticsdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import data.database.logisticsDB.CenterloadDB;
import data.database.logisticsDB.GoodsReceivingDB;
import data.database.logisticsDB.HallLoadDB;
import dataservice.logisticsdataservice.GoodsReceivingFormDataService;
import po.CenterloadPO;
import po.Formstate;
import po.GoodsReceivingPO;
import po.HallLoadPO;
import po.ResultMessage;

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
		return GoodsReceivingDB.write(po);
	}

	@Override
	public List<GoodsReceivingPO> getGoodsReceivingForm(Formstate state) throws RemoteException {
		return GoodsReceivingDB.fuzzySearch(state);
	}

	@Override
	public ResultMessage updateGoodsReceivingForm(GoodsReceivingPO po) throws RemoteException {
		return GoodsReceivingDB.update(po);
	}

	@Override
	public HallLoadPO getHallLoadBycode(String hallloadcode) throws RemoteException {
		// TODO Auto-generated method stub
		return HallLoadDB.getpoBymotorcode(hallloadcode);
	}

	@Override
	public CenterloadPO getCenterLoadBycode(String centerloadcode) throws RemoteException {
		// TODO Auto-generated method stub
		return CenterloadDB.getpoBymotorcode(centerloadcode);
	}

	@Override
	public long findLastID(String orgcode) throws RemoteException {
		// TODO Auto-generated method stub
		return GoodsReceivingDB.getLastId(orgcode);
	}


}
