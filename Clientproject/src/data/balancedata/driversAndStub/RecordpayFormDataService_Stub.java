package data.balancedata.driversAndStub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.Formstate;
import po.RecordpayPO;
import dataservice.balancedataservice.RecordpayFormDataService;

public class RecordpayFormDataService_Stub implements RecordpayFormDataService{

	@Override
	public List<RecordpayPO> getRecordpayForm(Formstate state)
			throws RemoteException {
		// TODO Auto-generated method stub
		List<RecordpayPO> list=new ArrayList<RecordpayPO>();
		RecordpayPO po=new RecordpayPO(012664, 20131230, 21000, "’≈¿ˆ", "6461335", 3346, 200, 4000, 1000, "nothing");
		list.add(po);
		return list;
	}

	@Override
	public void updateRecordpayForm(RecordpayPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update Succeed!\n");
		
	}

	@Override
	public void addRecordpayForm(RecordpayPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Add Succeed!\n");
		
	}

	@Override
	public List<RecordpayPO> getallRecordpayForm() throws RemoteException {
		// TODO Auto-generated method stub
		List<RecordpayPO> list=new ArrayList<RecordpayPO>();
		RecordpayPO po=new RecordpayPO(012664, 20131230, 21000.0, "’≈¿ˆ", "6461335", 3346, 200, 4000, 1000, "nothing");
		list.add(po);
		return list;
	}

	

}
