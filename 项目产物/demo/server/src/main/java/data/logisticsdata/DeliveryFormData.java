package data.logisticsdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import data.database.logisticsDB.DeliveryDB;
import dataservice.logisticsdataservice.DeliveryFormDataService;
import po.DeliveryPO;
import po.Formstate;
import po.ResultMessage;

public class DeliveryFormData extends UnicastRemoteObject implements DeliveryFormDataService{

	public DeliveryFormData() throws RemoteException{
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public List<DeliveryPO> getDeliveryForm(Formstate state,String orgcode) throws RemoteException {
		return DeliveryDB.fuzzySearch(state,orgcode);
	}

	@Override
	public ResultMessage updateDeliveryForm(DeliveryPO po) throws RemoteException {
		if(po!=null)
			return DeliveryDB.update(po);
		else
			return ResultMessage.failure;
	}

	@Override
	public ResultMessage addDeliveryForm(DeliveryPO po) throws RemoteException {
		if(po!=null)
			return DeliveryDB.write(po);
		else
			return ResultMessage.failure;
		
	}

	@Override
	public long findLastID(String orgcode) throws RemoteException {
		// TODO Auto-generated method stub
		return DeliveryDB.getLastId(orgcode);
	}


}
