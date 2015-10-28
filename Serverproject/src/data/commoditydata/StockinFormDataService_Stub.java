package data.commoditydata;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.City;
import po.CommodityLocation;
import po.Formstate;
import po.StockinPO;
import dataservice.commoditydataservice.StockinFormDataService;

public class StockinFormDataService_Stub implements StockinFormDataService{

	@Override
	public void addStockinForm(StockinPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Add Succeed!\n");
	}

	@Override
	public List<StockinPO> getStockinForm(Formstate state)
			throws RemoteException {
		// TODO Auto-generated method stub
		List<StockinPO> list=new ArrayList<StockinPO>();
		StockinPO po=new StockinPO(012276, "1204304632", 20130528, new CommodityLocation(120, 45, 77, 15),City.Guangzhou);
		list.add(po);
		return list;
	}

	@Override
	public void updateStockinForm(StockinPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update Succeed!\n");
	}



}
