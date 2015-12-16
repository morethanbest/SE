package businesslogic.managerbl.ConstantsPack;

import dataservice.managerdataservice.ConstantsDataService;
import init.RMIHelper;
import po.ConstantsPO;
import po.ResultMessage;

public class RevConstants {
	String name;
	double value;
	public void setRevInfo(String name,double value){
		this.value=value;
		this.name=name;
	}
	
	public ResultMessage rev(){
		ConstantsDataService constants=RMIHelper.getConstantsdata();
		ConstantsPO po;
		try {
			po = constants.findConstants(name);
			long id=po.getId();
			ConstantsPO newpo=new ConstantsPO(id,name,value);
			ResultMessage result=ResultMessage.success;
			System.out.println(id+" "+name+" "+value);
			if(result==ResultMessage.success){
				System.out.println("success");
			}
			else{
				System.out.println("false");
			}
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return ResultMessage.failure;
		}		
		
		
	}
}
