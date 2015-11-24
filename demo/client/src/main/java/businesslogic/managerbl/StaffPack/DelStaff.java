package businesslogic.managerbl.StaffPack;

import java.rmi.RemoteException;

import dataservice.managerdataservice.StaffDataService;
import init.RMIHelper;
import po.ResultMessage;
import po.StaffPO;

public class DelStaff {
	long id;
	public void setDelInfo(long id){
		this.id=id;
	}
	public ResultMessage delete(){
		StaffDataService staff=RMIHelper.getStaffdata();
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
