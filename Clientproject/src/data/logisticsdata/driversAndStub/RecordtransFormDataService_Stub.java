package data.logisticsdata.driversAndStub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.Formstate;
import po.Hall;
import po.RecordtransPO;
import dataservice.logisticsdataservice.RecordtransFormDataService;

public class RecordtransFormDataService_Stub implements RecordtransFormDataService{

	@Override
	public List<RecordtransPO> getRecordtransForm(Formstate state)
			throws RemoteException {
		// TODO Auto-generated method stub
		List<RecordtransPO> list=new ArrayList<RecordtransPO>();
		
		List<String> allbarcode=new ArrayList<String>();
		allbarcode.add("2014940328");
		RecordtransPO po=new RecordtransPO(1228565, 20140214, 20140301, "0251201411200000002", "CZ3903", Hall.Nanjing, Hall.Shanghai, "0122048", "ÀîÍú", allbarcode ,200);
		return list;
	}

	@Override
	public void updateRecordtransForm(RecordtransPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update Succeed!\n");
		
		
	}

	@Override
	public void addRecordtransForm(RecordtransPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Add Succeed!\n");
	}

	@Override
	public long findLastID() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public RecordtransPO getRecordtransForm(String transNumber)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
