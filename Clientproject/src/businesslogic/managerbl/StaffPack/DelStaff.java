package businesslogic.managerbl.StaffPack;

import java.rmi.RemoteException;

import data.managerdata.StaffData;
import dataservice.managerdataservice.StaffDataService;
import po.Job;
import po.StaffPO;
import vo.ResultMessage;

public class DelStaff {
	long id;
	public void setDelInfo(long id){
		this.id=id;
	}
	public ResultMessage delete() throws RemoteException{
		StaffDataService staff=new StaffData();
		StaffPO po=staff.findStaff(id);
		ResultMessage result=staff.deleteStaff(po);
		return result;
		
	}
}
