package businesslogic.managerbl.ConstantsPack;

import dataservice.managerdataservice.CityDataService;
import init.RMIHelper;
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
		CityDataService city=RMIHelper.getCitydata();
		ResultMessage resultMessage;
		try {
			resultMessage=city.deleteCity(po);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			resultMessage=ResultMessage.failure;
			System.out.println("delcity fail");
		}
		return resultMessage;
	}
}
