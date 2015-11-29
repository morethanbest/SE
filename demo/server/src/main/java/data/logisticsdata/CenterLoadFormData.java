package data.logisticsdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import data.database.logisticsDB.CenterloadDB;
import data.database.managerDB.ConstantsDB;
import data.database.orderDB.OrderDB;
import dataservice.logisticsdataservice.CenterLoadFormDataService;
import po.CenterloadPO;
import po.ConstantsPO;
import po.Formstate;
import po.ResultMessage;

public class CenterLoadFormData extends UnicastRemoteObject implements CenterLoadFormDataService{

	public CenterLoadFormData() throws  RemoteException{
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public List<CenterloadPO> getCenterLoadForm(Formstate state) throws RemoteException {
		return CenterloadDB.fuzzySearch(state);
	}

	@Override
	public ResultMessage updateCenterLoadForm(CenterloadPO po) throws RemoteException {
		return CenterloadDB.update(po);
	}

	@Override
	public ResultMessage addCenterLoadForm(CenterloadPO po) throws RemoteException {
		return CenterloadDB.write(po);
	}

	@Override
	public long findLastmotorcode(String orgcode, String date) throws RemoteException {
		// TODO Auto-generated method stub
		return CenterloadDB.getLastId(orgcode+date);
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

	
//	public static void main(String[] args){
//		try{
//			CenterLoadFormData data=new CenterLoadFormData();
//			System.out.println(data.getweight("0000000001"));
//			System.out.println(data.getdistance("上海", "南京"));
//			System.out.println(data.getunitprice("汽车"));
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}

	
}
