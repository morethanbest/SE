package businesslogic.managerbl.ConstantsPack;

import po.ConstantsPO;
import vo.ResultMessage;

public class MockRevConstants extends RevConstants{
	String name;
	double value;
	public void setRevInfo(String name,double value){
		this.value=value;
		this.name=name;
	}
	
	public ResultMessage rev(){
		ConstantsPO po=new ConstantsPO(5,name,5);		//以后为从数据层拿，再删去
		long id=po.getId();
		ConstantsPO newpo=new ConstantsPO(id,name,value);
		ResultMessage result=ResultMessage.success;
		return result;
		
	}
}
