package data.balancedata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import data.database.accountDB.AccountDB;
import data.database.balanceDB.RecordcollectDB;
import dataservice.balancedataservice.RecordcollectFormDataService;
import po.AccountPO;
import po.Formstate;
import po.RecordcollectPO;
import po.ResultMessage;

public class RecordcollectFormData extends UnicastRemoteObject implements RecordcollectFormDataService{

	public RecordcollectFormData() throws RemoteException{
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public ResultMessage addRecordcollectForm(RecordcollectPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(po!=null)
			return RecordcollectDB.write(po);
		else
			return ResultMessage.failure;
	}

	@Override
	public List<RecordcollectPO> getRecordcollectForm(Formstate state, String orgcode) throws RemoteException {
		// TODO Auto-generated method stub
		return RecordcollectDB.fuzzySearch(state, orgcode);
	}

	@Override
	public ResultMessage updateRecordcollectForm(RecordcollectPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(po!=null)
			return RecordcollectDB.update(po);
		else
			return ResultMessage.failure;
		
	}

	@Override
	public long getlastid(String orgcode) throws RemoteException {
		// TODO Auto-generated method stub
		return RecordcollectDB.getLastId(orgcode);
	}

	@Override
	public ResultMessage addmoney(String accountname, double fee) throws RemoteException {
		// TODO Auto-generated method stub
		ResultMessage result=ResultMessage.failure;
		try{
			AccountPO account=AccountDB.search(accountname);
			account.setAccountsum(fee+account.getAccountsum());			//账户的钱为原来的钱加上这次增加的钱
			result=AccountDB.update(account);									//更新数据库中的账户信息
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;							

	}

}
