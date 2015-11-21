package businesslogic.managerbl.StaffPack;

import java.rmi.RemoteException;

import data.managerdata.StaffData;
import dataservice.managerdataservice.StaffDataService;
import po.Job;
import po.StaffPO;
import vo.ResultMessage;
import vo.StaffVO;

public class RevStaff {
	long id;
	String name;
	Job job;
	public void setRevInfo(Long id, String name,Job job){
		this.id=id;
		this.job=job;
		this.name=name;
	}
	
	public ResultMessage rev() throws RemoteException{
		StaffDataService staff=new StaffData();
		StaffPO po=staff.findStaff(id);
		ResultMessage result=staff.updateStaff(po);
		return result;
		
	}
}
