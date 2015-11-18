package data.logisticsdata.driversAndStub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.DeliveryPO;
import po.Formstate;
import dataservice.logisticsdataservice.DeliveryFormDataService;

public class DeliveryFormDataService_Stub implements DeliveryFormDataService{

	@Override
	public List<DeliveryPO> getDeliveryForm(Formstate state)
			throws RemoteException {
		// TODO Auto-generated method stub
		List<DeliveryPO> list=new ArrayList<DeliveryPO>();
		DeliveryPO po=new DeliveryPO(12056, 20150121, "0120641289", "Ëï½¡");
		list.add(po);
		return list;
	}

	@Override
	public void updateDeliveryForm(DeliveryPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update Succeed!\n");
		
	}

	@Override
	public void addDeliveryForm(DeliveryPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Add Succeed!\n");
		
	}

	@Override
	public long findLastID() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
