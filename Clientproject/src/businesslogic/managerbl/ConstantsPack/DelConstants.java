package businesslogic.managerbl.ConstantsPack;

import java.rmi.RemoteException;

import data.managerdata.ConstantsData;
import dataservice.managerdataservice.ConstantsDataService;
import po.ConstantsPO;
import vo.ResultMessage;

public class DelConstants {
	String name;
	double value;
	public void setDelInfo(String name,double value){
		this.value=value;
		this.name=name;
	}
	
	public ResultMessage delete() throws RemoteException{
		ConstantsDataService constants=new ConstantsData();
		ConstantsPO po=constants.findConstants(name);
		ResultMessage result=constants.deleteConstants(po);
		return result;
		
	}
}
