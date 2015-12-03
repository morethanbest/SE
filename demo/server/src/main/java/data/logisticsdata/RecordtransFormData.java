package data.logisticsdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import data.database.logisticsDB.RecordtransDB;
import data.database.managerDB.ConstantsDB;
import data.database.orderDB.OrderDB;
import dataservice.logisticsdataservice.RecordtransFormDataService;
import po.ConstantsPO;
import po.Formstate;
import po.RecordtransPO;
import po.ResultMessage;

public class RecordtransFormData extends UnicastRemoteObject implements RecordtransFormDataService{

	public RecordtransFormData() throws  RemoteException{
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public List<RecordtransPO> getRecordtransForm(Formstate state,String orgcode) throws RemoteException {
		return RecordtransDB.fuzzySearch(state,orgcode);
	}

	@Override
	public ResultMessage updateRecordtransForm(RecordtransPO po) throws RemoteException {
		return RecordtransDB.update(po);
	}

	@Override
	public ResultMessage addRecordtransForm(RecordtransPO po) throws RemoteException {
		return RecordtransDB.write(po);
	}

	@Override
	public long findLasttranscode(String orgcode, long date) throws RemoteException {
		// TODO Auto-generated method stub
		return RecordtransDB.getLastId(orgcode+Long.toString(date));
	}

	@Override
	public double getunitprice(String transporttype) throws RemoteException {
		// TODO Auto-generated method stub
		double unitprice=0;
		String name="运输类型-"+transporttype;
		ConstantsPO constants=ConstantsDB.search(name);
		unitprice=constants.getValue();
		return unitprice;
	}

	@Override
	public double getdistance(String city1, String city2) throws RemoteException {
		// TODO Auto-generated method stub
		double distance=0;
		String name="距离-"+city1+"-"+city2;
		ConstantsPO constants=ConstantsDB.search(name);
		distance=constants.getValue();
		return distance;
	}

	@Override
	public double getweight(String ordernum) throws RemoteException {
		// TODO Auto-generated method stub
		return OrderDB.getWeight(ordernum);
	}

}
