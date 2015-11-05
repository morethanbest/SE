package data.managerdata;

import java.rmi.RemoteException;

import po.Organization;
import po.OrganizationPO;
import dataservice.managerdataservice.OrganizationDataService;

public class OrganizationDataService_Stub implements OrganizationDataService{

	@Override
	public void addOrganization(OrganizationPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Add Succeed!\n");
		
	}

	@Override
	public void deleteOrganization(OrganizationPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Delete Succeed!\n");
	}

	@Override
	public void updateOrganization(OrganizationPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update Succeed!\n");
	}

	@Override
	public OrganizationPO findOrganization(String name)
			throws RemoteException {
		// TODO Auto-generated method stub
		OrganizationPO po=new OrganizationPO(1, "�Ͼ���¥",Organization.hall );
		return po;
	}



}
