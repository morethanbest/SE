package data.logisticsdata;

import dataservice.logisticsdataservice.DeliveryFormDataService;
import po.DeliveryPO;
import po.Formstate;
import po.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class DeliveryFormData extends UnicastRemoteObject implements DeliveryFormDataService{

	public DeliveryFormData() throws RemoteException{
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public List<DeliveryPO> getDeliveryForm(Formstate state) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage updateDeliveryForm(DeliveryPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage addDeliveryForm(DeliveryPO po) throws RemoteException {
		return null;
	}

	@Override
	public long findLastID() throws RemoteException {
		return 0;
	}
}
