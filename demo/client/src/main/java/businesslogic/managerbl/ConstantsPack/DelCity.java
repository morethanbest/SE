package businesslogic.managerbl.ConstantsPack;

import po.CityPO;
import po.ResultMessage;

public class DelCity {
	String name;
	String zone;
	public void setCityInfo(String name, String zone){
		this.name=name;
		this.zone=zone;
	}
	public ResultMessage delCity(){
		CityPO po=new CityPO(name, zone);
		return ResultMessage.failure;
	}
}
