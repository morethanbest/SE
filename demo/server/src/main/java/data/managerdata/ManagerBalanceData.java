package data.managerdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import data.database.balanceDB.RecordcollectDB;
import data.database.balanceDB.RecordpayDB;
import dataservice.managerdataservice.ManagerBalanceDataService;
import po.Formstate;
import po.RecordcollectPO;
import po.RecordpayPO;

public class ManagerBalanceData extends UnicastRemoteObject implements ManagerBalanceDataService {

	public ManagerBalanceData() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double allin() throws RemoteException {
		// TODO Auto-generated method stub
		double result=0;
		List<RecordcollectPO> list=RecordcollectDB.fuzzySearch(Formstate.checked);		//获得所有已经被确认过的收款单
		for(RecordcollectPO recordcollect :list){
			result+=recordcollect.getCollectionsum();
		}
		return result;
	}

	@Override
	public double allout() throws RemoteException {
		// TODO Auto-generated method stub
		double result=0;
		List<RecordpayPO> list=RecordpayDB.fuzzySearch(Formstate.checked);
		for(RecordpayPO recordpay :list){
			result+=recordpay.getPaysum();
		}
		return result;
	}

}
