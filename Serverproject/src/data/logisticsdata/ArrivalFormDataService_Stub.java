package data.logisticsdata;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.ArrivalPO;
import po.Arrivalstate;
import po.Formstate;
import po.Hall;
import dataservice.logisticsdataservice.ArrivalFormDataService;

public class ArrivalFormDataService_Stub implements ArrivalFormDataService{

	@Override
	public List<ArrivalPO> getArrivalForm(Formstate state)
			throws RemoteException {
		// TODO Auto-generated method stub
		List<ArrivalPO> list=new ArrayList<ArrivalPO>();
		ArrivalPO po=new ArrivalPO(1205656, "02507", 20130417, "0251201411200000002", Hall.Shanghai, Arrivalstate.intact);
		return null;
	}

	@Override
	public void updateArrivalForm(ArrivalPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update Succeed!\n");
		
	}

	@Override
	public void addArrivalForm(ArrivalPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Add Succeed!\n");
	}

	

}
