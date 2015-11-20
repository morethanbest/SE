package businesslogic.managerbl.ConstantsPack;

import java.rmi.RemoteException;

import data.managerdata.ConstantsData;
import dataservice.managerdataservice.ConstantsDataService;
import po.ConstantsPO;
import vo.ResultMessage;

public class AddConstants {
	long id;
	String name;
	double value ;
	
	public void setAddInfo(long id,String name,double value){
		this.id=id;
		this.name=name;
		this.value=value;
	}
	public ResultMessage addConstants() throws RemoteException{
		ConstantsPO po=new ConstantsPO(id,name,value);
		ConstantsDataService constants=new ConstantsData();
		ResultMessage result=constants.addConstants(po);
		return result;
	}
}
