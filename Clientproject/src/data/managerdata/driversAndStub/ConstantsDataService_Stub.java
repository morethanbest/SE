package data.managerdata.driversAndStub;

import java.rmi.RemoteException;

import po.ConstantsPO;
import dataservice.managerdataservice.ConstantsDataService;

public class ConstantsDataService_Stub implements ConstantsDataService {

	@Override
	public void addConstants(ConstantsPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Add Succeed!\n");
		
	}

	@Override
	public void deleteConstants(ConstantsPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Delete Succeed!\n");
	}

	@Override
	public void updateConstants(ConstantsPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update Succeed!\n");
	}

	@Override
	public ConstantsPO findConstants(String name) throws RemoteException {
		// TODO Auto-generated method stub
		ConstantsPO po=new ConstantsPO(1, "Shanghai--Nanajing", 266);
		
		return po;
	}


}
