package businesslogic.managerbl.ConstantsPack;

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
	public ResultMessage addConstants(){
		ConstantsPO po=new ConstantsPO(id,name,value);
		ConstantsDataService constants=new ConstantsData();
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
