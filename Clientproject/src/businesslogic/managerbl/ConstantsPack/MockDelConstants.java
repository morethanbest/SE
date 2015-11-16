package businesslogic.managerbl.ConstantsPack;

import po.ConstantsPO;
import vo.ResultMessage;

public class MockDelConstants extends DelConstants{
	String name;
	double value;
	public void setDelInfo(String name,double value){
		this.value=value;
		this.name=name;
	}
	
	public ResultMessage delete(){
		ConstantsPO po=new ConstantsPO(5,name,value);		//以后为从数据层拿，再删去
		
		ResultMessage result=ResultMessage.success;
		return result;
		
	}
}
