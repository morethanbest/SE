package data.commoditydata;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.Formstate;
import po.Hall;
import po.Loadform;
import po.StockinPO;
import po.StockoutPO;
import dataservice.commoditydataservice.StockoutFormDataService;

public class StockoutFormDataService_Stub implements StockoutFormDataService{

	@Override
	public void updateStockinForm(StockinPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update Succeed!\n");
		
	}

	@Override
	public void addStockoutForm(StockoutPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Add Succeed!\n");
		
	}

	@Override
	public List<StockoutPO> getStockoutForm(Formstate state)
			throws RemoteException {
		// TODO Auto-generated method stub
		List<StockoutPO> list=new ArrayList<StockoutPO>();
		StockoutPO po=new StockoutPO(4520556,1036565287, 20140517, Hall.Nanjing1, Loadform.truck, 782114, 46614200);
		list.add(po);
		return list;
	}

	

}
