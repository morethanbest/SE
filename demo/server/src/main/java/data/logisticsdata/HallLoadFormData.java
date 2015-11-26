package data.logisticsdata;

import dataservice.logisticsdataservice.HallLoadFormDataService;
import po.Formstate;
import po.HallLoadPO;
import po.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class HallLoadFormData extends UnicastRemoteObject implements HallLoadFormDataService{

	public HallLoadFormData() throws RemoteException{
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public ResultMessage addLoadForm(HallLoadPO po) throws RemoteException {
		return null;
	}

	@Override
	public List<HallLoadPO> getLoadForm(Formstate state) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage updateLoadForm(HallLoadPO po) throws RemoteException {
		return null;
	}

	@Override
	public String findLastmotorcode(String orgcode) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
