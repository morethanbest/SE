package data.balancedata.driversAndStub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.Formstate;
import po.RecordcollectPO;
import dataservice.balancedataservice.RecordcollectFormDataService;

public class RecordcollectFormDataService_Stub implements RecordcollectFormDataService{

	@Override
	public void addRecordcollectForm(RecordcollectPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Add Succeed!\n");
		
	}

	@Override
	public List<RecordcollectPO> getRecordcollectForm(Formstate state)
			throws RemoteException {
		// TODO Auto-generated method stub
		List<RecordcollectPO> list=new ArrayList<RecordcollectPO>();
		List<String> allordercode=new ArrayList<String>();
		allordercode.add("1112014245");
		
		RecordcollectPO collectpo=new RecordcollectPO(12244, 20140412, 140000.0, "Õı≈Ù", allordercode);
		
		list.add(collectpo);
		return list;
	}

	@Override
	public void updateRecordcollectForm(RecordcollectPO po)
			throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update Succeed!\n");
		
	}

	@Override
	public List<RecordcollectPO> getallRecordcollectForm()
			throws RemoteException {
		// TODO Auto-generated method stub
		List<RecordcollectPO> list=new ArrayList<RecordcollectPO>();
		
		List<String> allordercode=new ArrayList<String>();
		allordercode.add("1112014245");
		RecordcollectPO collectpo=new RecordcollectPO(12244, 20140412, 140000.0, "Õı≈Ù", allordercode);
		
		list.add(collectpo);
		return list;
	}

	

}
