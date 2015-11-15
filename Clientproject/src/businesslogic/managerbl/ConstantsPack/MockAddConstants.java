package businesslogic.managerbl.ConstantsPack;

import po.ConstantsPO;
import vo.ResultMessage;

public class MockAddConstants extends AddConstants{
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
		ResultMessage result=ResultMessage.success;
		return result;
	}
}
