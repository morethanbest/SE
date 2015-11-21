package businesslogic.managerbl.StaffPack;

import java.rmi.RemoteException;

import data.managerdata.StaffData;
import dataservice.managerdataservice.StaffDataService;
import po.Job;
import po.StaffPO;
import vo.ResultMessage;

public class AddStaff {
	long id;
	String name;
	Job job;
	public void setAddInfo(long id,String name,Job job){
		this.id=id;
		this.name=name;
		this.job=job;
	}
	public ResultMessage addStaff() throws RemoteException{
		StaffPO po=new StaffPO(id,name,job);
		StaffDataService staff=new StaffData();
		ResultMessage result=staff.addStaff(po);
		return result;
	}
}
