package data.accountdata;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.NewbookPO;
import dataservice.accountdataservice.NewBookDataService;

public class NewBookDataService_Stub implements NewBookDataService{

	@Override
	public void addNewBook(NewbookPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Add Succeed!\n");
		
	}

	@Override
	public List<NewbookPO> findNewBook(long time) throws RemoteException {
		// TODO Auto-generated method stub
		List <NewbookPO> list=new ArrayList<NewbookPO>();
		list.add(new NewbookPO(time, null, null, null, null, null));
		return list;
	}

	

}
