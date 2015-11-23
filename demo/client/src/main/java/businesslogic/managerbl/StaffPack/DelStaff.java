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
	public ResultMessage delete(){
		StaffDataService staff=new StaffData();
		StaffPO po;
		ResultMessage result;
		try {
			po = staff.findStaff(id);
			result=staff.deleteStaff(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			result=ResultMessage.failure;
			System.out.println("delstaff fail");
		}
		
		return result;
		
	}
}
