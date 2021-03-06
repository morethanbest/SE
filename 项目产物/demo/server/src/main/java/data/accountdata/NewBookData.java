package data.accountdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import data.database.accountDB.AccountDB;
import data.database.accountDB.NewBookDB;
import data.database.commodityDB.CommodityDB;
import data.database.managerDB.OrganizationDB;
import data.database.managerDB.StaffDB;
import data.database.transportDB.VehicleDB;
import dataservice.accountdataservice.NewBookDataService;
import po.NewbookPO;
import po.ResultMessage;

public class NewBookData extends UnicastRemoteObject implements NewBookDataService{

	public NewBookData() throws  RemoteException{
		super();
	}

	@Override
	public ResultMessage addNewBook(NewbookPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(po!=null)
			return NewBookDB.write(po);
		else
			return ResultMessage.failure;
	}

	@Override
	public NewbookPO findNewBook(long time) throws RemoteException {
		// TODO Auto-generated method stub
		return NewBookDB.search(time);
	}

	@Override
	public NewbookPO getLastBook() throws RemoteException {
		// TODO Auto-generated method stub
		NewbookPO po = new NewbookPO(1,1,AccountDB.getAll(),CommodityDB.getAll(),OrganizationDB.getAll(),StaffDB.getAll(),VehicleDB.getAll());
		return po;
	}

	@Override
	public long getid() throws RemoteException {
		// TODO Auto-generated method stub
		return NewBookDB.getLastId();
	}



}
