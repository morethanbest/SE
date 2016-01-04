package data.balancedata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import data.database.accountDB.AccountDB;
import data.database.balanceDB.RecordpayDB;
import dataservice.balancedataservice.RecordpayFormDataService;
import po.AccountPO;
import po.Formstate;
import po.RecordpayPO;
import po.ResultMessage;

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
		if(po!=null)
			return RecordpayDB.update(po);
		else
			return ResultMessage.failure;
		
	}

	@Override
	public ResultMessage addRecordpayForm(RecordpayPO po) throws RemoteException {
		if(po!=null)
			return RecordpayDB.write(po);
		else
			return ResultMessage.failure;
		
	}

	@Override
	public ResultMessage removeTheCost(String accountname, double fee) throws RemoteException {
		// TODO Auto-generated method stub
		ResultMessage result=ResultMessage.failure;
		try{
			AccountPO account=AccountDB.search(accountname);
			account.setAccountsum(account.getAccountsum()-fee);			//账户的钱为原来的钱减去这次应扣除的钱
			result=AccountDB.update(account);							//更新数据库中的账户信息
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public long getlastid() throws RemoteException {
		// TODO Auto-generated method stub
		return RecordpayDB.getLastId();
	}
	


}
