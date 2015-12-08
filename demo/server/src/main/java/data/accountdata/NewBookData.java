package data.accountdata;

import dataservice.accountdataservice.NewBookDataService;
import po.AccountPO;
import po.NewbookPO;
import po.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import data.database.accountDB.AccountDB;
import data.database.commodityDB.CommodityDB;
import data.database.managerDB.OrganizationDB;
import data.database.managerDB.StaffDB;
import data.database.transportDB.VehicleDB;

public class NewBookData extends UnicastRemoteObject implements NewBookDataService{

	public NewBookData() throws  RemoteException{
		super();
	}

	@Override
	public ResultMessage addNewBook(NewbookPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NewbookPO findNewBook(long time) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NewbookPO getLastBook() throws RemoteException {
		// TODO Auto-generated method stub
		NewbookPO po = new NewbookPO(1,1,AccountDB.getAll(),CommodityDB.getAll(),OrganizationDB.getAll(),StaffDB.getAll(),VehicleDB.getAll());
		return null;
	}

	@Override
	public long getid() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}



}
