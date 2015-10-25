package data.logisticsdata;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.Arrivalstate;
import po.Formstate;
import po.GoodsReceivingPO;
import po.Hall;
import dataservice.logisticsdataservice.GoodsReceivingFormDataService;

public class GoodsReceivingFormDataService_Stub implements GoodsReceivingFormDataService{

	@Override
	public void addGoodsReceivingForm(GoodsReceivingPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Add Succeed!\n");
		
	}

	@Override
	public List<GoodsReceivingPO> getGoodsReceivingForm(Formstate state)
			throws RemoteException {
		// TODO Auto-generated method stub
		List<GoodsReceivingPO> list=new ArrayList<GoodsReceivingPO>();
		GoodsReceivingPO po=new GoodsReceivingPO(425220, 20140521, "0251201411200000002", Hall.Nanjing, Arrivalstate.intact);
		list.add(po);
		return list;
	}

	@Override
	public void updateGoodsReceivingForm(GoodsReceivingPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update Succeed!\n");
	}



}
