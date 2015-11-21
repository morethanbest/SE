package businesslogic.managerbl.ConstantsPack;

import java.rmi.RemoteException;

import data.managerdata.ConstantsData;
import dataservice.managerdataservice.ConstantsDataService;
import po.ConstantsPO;
import vo.ResultMessage;

public class RevConstants {
	String name;
	double value;
	public void setRevInfo(String name,double value){
		this.value=value;
		this.name=name;
	}
	
	public ResultMessage rev() throws RemoteException{
		ConstantsDataService constants=new ConstantsData();
		ConstantsPO po=constants.findConstants(name);		//以后为从数据层拿，再删去
		long id=po.getId();
		ConstantsPO newpo=new ConstantsPO(id,name,value);
		ResultMessage result=ResultMessage.success;
		return result;
		
	}
}
