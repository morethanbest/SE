package data.logisticsdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import data.database.logisticsDB.HallLoadDB;
import data.database.managerDB.ConstantsDB;
import data.database.orderDB.OrderDB;
import dataservice.logisticsdataservice.HallLoadFormDataService;
import po.ConstantsPO;
import po.Formstate;
import po.HallLoadPO;
import po.ResultMessage;

public class HallLoadFormData extends UnicastRemoteObject implements HallLoadFormDataService{

	public HallLoadFormData() throws RemoteException{
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public ResultMessage addLoadForm(HallLoadPO po) throws RemoteException {
		if(po!=null)
			return HallLoadDB.write(po);
		else 
			return ResultMessage.failure;
	}

	@Override
	public List<HallLoadPO> getLoadForm(Formstate state,String orgcode) throws RemoteException {
		return HallLoadDB.fuzzySearch(state,orgcode);
	}

	@Override
	public ResultMessage updateLoadForm(HallLoadPO po) throws RemoteException {
		if(po!=null)
			return HallLoadDB.update(po);
		else 
			return ResultMessage.failure;
		
	}

	@Override
	public long findLastmotorcode(String orgcode, long date) throws RemoteException {
		// TODO Auto-generated method stub
		return HallLoadDB.getLastId(orgcode+Long.toString(date));
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

	@Override
	public boolean checkHallLoad(String motorcode) throws RemoteException {
		// TODO Auto-generated method stub
		if(HallLoadDB.getpoBymotorcode(motorcode)!=null){
			return true;
		}else
			return false;
	}



	
}
