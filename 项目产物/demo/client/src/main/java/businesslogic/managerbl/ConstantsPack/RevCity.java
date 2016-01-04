package businesslogic.managerbl.ConstantsPack;

import dataservice.managerdataservice.CityDataService;
import init.RMIHelper;
import po.CityPO;
import po.ResultMessage;

public class RevCity {
	String name;
	String zone;
	public void setCityInfo(String name, String zone){
		this.name=name;
		this.zone=zone;
	}
	public ResultMessage updateCity(){
		CityDataService cityDataService=RMIHelper.getCitydata();
		CityPO po=new CityPO(name, zone);
		ResultMessage resultMessage;
		try {
			resultMessage=cityDataService.updateCity(po);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			resultMessage=ResultMessage.failure;
			System.out.println("RevCity fail");
		}
		return resultMessage;
	}
}
