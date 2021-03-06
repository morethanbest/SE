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
	
	public ResultMessage delete(){
		ConstantsDataService constants=new ConstantsData();
		ConstantsPO po;
		ResultMessage result;
		try {
			po = constants.findConstants(name);
			result=constants.deleteConstants(po);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result=ResultMessage.failure;
			System.out.println("delconstants fail");
		}
		
		return result;
		
	}
}
