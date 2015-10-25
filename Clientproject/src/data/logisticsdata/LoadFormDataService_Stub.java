package data.logisticsdata;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.Formstate;
import po.Hall;
import po.LoadPO;
import dataservice.logisticsdataservice.LoadFormDataService;

public class LoadFormDataService_Stub implements LoadFormDataService{

	@Override
	public void addLoadForm(LoadPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Add Succeed!\n");
	}

	@Override
	public List<LoadPO> getLoadForm(Formstate state) throws RemoteException {
		// TODO Auto-generated method stub
		List<LoadPO> list=new ArrayList<LoadPO>();
		
		List<String> allbarcode=new ArrayList<String>();
		allbarcode.add("2014940328");
		LoadPO po=new LoadPO(05510, 20131210, "02500", "025002015092100001", Hall.Shanghai, "025000001", "’‘∑¢", "’≈¡¡", allbarcode, 100);
		list.add(po);
		return list;
	}

	@Override
	public void updateLoadForm(LoadPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update Succeed!\n");
	}

	

}
