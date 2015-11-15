package businesslogic.managerbl.ConstantsPack;

import po.ConstantsPO;
import vo.ConstantsVO;

public class MockFindConstants extends FindConstants{

	String name;
	
	public void setFindInfo(String name){
		this.name=name;
	}
	public ConstantsVO findConstants(){
		ConstantsPO po=new ConstantsPO(5,name,5);		//以后为从数据层拿
		double value=po.getValue();
		String name=po.getName();
		ConstantsVO vo=new ConstantsVO(name,value);
		return vo;
	}
}
