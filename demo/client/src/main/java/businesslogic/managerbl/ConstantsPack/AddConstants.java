package businesslogic.managerbl.ConstantsPack;

import dataservice.managerdataservice.ConstantsDataService;
import init.RMIHelper;
import po.ConstantsPO;
import po.ResultMessage;

public class AddConstants {
	long id;
	String name;
	double value ;
	
	public void setAddInfo(long id,String name,double value){
		this.id=id;
		this.name=name;
		this.value=value;
	}
	public ResultMessage addConstants(){
		ConstantsPO po=new ConstantsPO(id,name,value);
		ConstantsDataService constants=RMIHelper.getConstantsdata();
		ResultMessage result;
		try {
			result = constants.addConstants(po);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result = ResultMessage.failure;
			System.out.println("addconstants fail");
		}
		return result;
	}
}
