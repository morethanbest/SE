package data.logisticsdata;

import dataservice.logisticsdataservice.CenterLoadFormDataService;
import po.CenterloadPO;
import po.Formstate;
import po.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class CenterLoadFormData extends UnicastRemoteObject implements CenterLoadFormDataService{

	public CenterLoadFormData() throws  RemoteException{
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public List<CenterloadPO> getCenterLoadForm(Formstate state) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage updateCenterLoadForm(CenterloadPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage addCenterLoadForm(CenterloadPO po) throws RemoteException {
		return null;
	}

	@Override
	public String findLastmotorcode(String orgcode) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
