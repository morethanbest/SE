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
		if(po!=null)
			return RecordtransDB.update(po);
		else 
			return ResultMessage.failure ;
		
	}

	@Override
	public ResultMessage addRecordtransForm(RecordtransPO po) throws RemoteException {
		if(po!=null)
			return RecordtransDB.write(po);
		else 
			return ResultMessage.failure ;
		
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
		try{
			ConstantsPO constants=ConstantsDB.search(name);
			unitprice=constants.getValue();
		}catch(Exception e){
			e.printStackTrace();
		}
		return unitprice;
	}

	@Override
	public double getdistance(String city1, String city2) throws RemoteException {
		// TODO Auto-generated method stub
		double distance=0;
		String name="距离-"+city1+"-"+city2;
		try{
			ConstantsPO constants=ConstantsDB.search(name);
			distance=constants.getValue();
		}catch(Exception e){
			e.printStackTrace();
		}
		return distance;
	}

	@Override
	public double getweight(String ordernum) throws RemoteException {
		// TODO Auto-generated method stub
		return OrderDB.getWeight(ordernum);
	}

}
