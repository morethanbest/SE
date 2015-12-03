package data.balancedata;

import dataservice.balancedataservice.RecordpayFormDataService;
import po.AccountPO;
import po.Formstate;
import po.RecordpayPO;
import po.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import data.database.accountDB.AccountDB;
import data.database.balanceDB.RecordpayDB;

public class RecordpayFormData extends UnicastRemoteObject implements RecordpayFormDataService{

	public RecordpayFormData() throws  RemoteException{
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public List<RecordpayPO> getRecordpayForm(Formstate state) throws RemoteException {
		return RecordpayDB.fuzzySearch(state);
	}

	@Override
	public ResultMessage updateRecordpayForm(RecordpayPO po) throws RemoteException {
		return RecordpayDB.update(po);
	}

	@Override
	public ResultMessage addRecordpayForm(RecordpayPO po) throws RemoteException {
		return RecordpayDB.write(po);
	}

	@Override
	public ResultMessage removeTheCost(String accountname, double fee) throws RemoteException {
		// TODO Auto-generated method stub
		AccountPO account=AccountDB.search(accountname);
		account.setAccountsum(account.getAccountsum()-fee);			//账户的钱为原来的钱减去这次应扣除的钱
		return AccountDB.update(account);							//更新数据库中的账户信息
	}

	@Override
	public long getlastid() throws RemoteException {
		// TODO Auto-generated method stub
		return RecordpayDB.getLastId();
	}
	


}
