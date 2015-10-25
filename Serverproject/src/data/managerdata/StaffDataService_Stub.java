package data.managerdata;

import java.rmi.RemoteException;

import po.Job;
import po.StaffPO;
import dataservice.managerdataservice.StaffDataService;

public class StaffDataService_Stub implements StaffDataService{

	@Override
	public void addStaff(StaffPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Add Succeed!\n");
		
	}

	@Override
	public void deleteStaff(StaffPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Delete Succeed!\n");
	}

	@Override
	public void updateStaff(StaffPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update Succeed!\n");
	}

	@Override
	public StaffPO findStaff(long Staffid) throws RemoteException {
		// TODO Auto-generated method stub
		StaffPO po=new StaffPO(01235, "ÀîÍú", Job.transfercenter);
		return po;
	}

	

}
