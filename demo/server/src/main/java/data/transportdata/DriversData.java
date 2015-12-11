package data.transportdata;

import dataservice.transportdataservice.DriversDataService;
import po.DriversPO;
import po.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Driver;
import java.util.List;

import data.database.transportDB.DriverDB;

public class DriversData extends UnicastRemoteObject implements DriversDataService{

	public DriversData() throws  RemoteException{
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public ResultMessage insertDriver(DriversPO po) throws RemoteException {
		if(po!=null)
			return DriverDB.write(po);
		else
			return ResultMessage.failure;
	}

	@Override
	public ResultMessage deleteDriver(DriversPO po) throws RemoteException {
		if(po!=null)
			return  DriverDB.delete(po);
		else
			return ResultMessage.failure;
		
	}

	@Override
	public ResultMessage updateDriver(DriversPO po) throws RemoteException {
		if(po!=null)
			return DriverDB.update(po);
		else
			return ResultMessage.failure;
		
	}

	@Override
	public DriversPO findDriverBynum(String identity) throws RemoteException {
		return DriverDB.search(identity);
	}

	@Override
	public List<DriversPO> findDriverByname(String identity) throws RemoteException {
		return DriverDB.fuzzysearch(identity);
	}

	@Override
	public long getCurrentID(String orgcode) throws RemoteException {
		// TODO Auto-generated method stub
		return DriverDB.getlastcode(orgcode);
	}

	
//	public static void main(String[] args){
//		try{
//			DriversData data=new DriversData();
//			System.out.println(data.getCurrentID("025"));
//		}catch(Exception e){
//			e.printStackTrace();
//			
//		}
//	}

}
