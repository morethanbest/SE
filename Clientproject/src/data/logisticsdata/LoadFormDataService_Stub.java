package data.logisticsdata;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.Formstate;
import po.Hall;
import po.HallLoadPO;
import dataservice.logisticsdataservice.HallLoadFormDataService;

public class LoadFormDataService_Stub implements HallLoadFormDataService{

	@Override
	public void addLoadForm(HallLoadPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Add Succeed!\n");
	}

	@Override
	public List<HallLoadPO> getLoadForm(Formstate state) throws RemoteException {
		// TODO Auto-generated method stub
		List<HallLoadPO> list=new ArrayList<HallLoadPO>();
		
		List<String> allbarcode=new ArrayList<String>();
		allbarcode.add("2014940328");
		HallLoadPO po=new HallLoadPO(05510, 20131210, "02500", "025002015092100001", Hall.Shanghai, "025000001", "’‘∑¢", "’≈¡¡", allbarcode, 100);
		list.add(po);
		return list;
	}

	@Override
	public void updateLoadForm(HallLoadPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update Succeed!\n");
	}

	@Override
	public long findLastID() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
