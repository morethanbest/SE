package businesslogic.managerbl.ConstantsPack;

import dataservice.managerdataservice.CityDataService;
import init.RMIHelper;
import po.CityPO;
import po.ResultMessage;

public class AddCity {
	String name;
	String zone;
	public void setCityInfo(String name, String zone){
		this.name=name;
		this.zone=zone;
	}
	public ResultMessage addCity(){
		CityPO po=new CityPO(name, zone);
//		CityDataService city=RMIHelper.get
		return ResultMessage.failure;
	}
}
