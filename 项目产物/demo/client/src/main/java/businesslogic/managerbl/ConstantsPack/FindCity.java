package businesslogic.managerbl.ConstantsPack;

import java.util.ArrayList;
import java.util.List;

import dataservice.managerdataservice.CityDataService;
import init.RMIHelper;
import po.CityPO;
import vo.CityVO;

public class FindCity {
	String name;
	public void setCityInfo(String name){
		this.name=name;
	}
	public List<CityVO> getAll(){
		CityDataService cityDataService=RMIHelper.getCitydata();
		List<CityVO> listvo=new ArrayList<CityVO>();
		try {
			List<CityPO> listpo=cityDataService.getAll();
			for(int i=0;i<listpo.size();i++){
				CityPO po=listpo.get(i);
				String poname=po.getName();
				String zone=po.getZone();
				CityVO vo=new CityVO(poname, zone);
				listvo.add(vo);			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block

			listvo=null;
			System.out.println("getallcity fail");
		}
		return listvo;
	}
	public CityVO findCity(){
		CityDataService cityDataService=RMIHelper.getCitydata();
		CityVO vo;
		try {
			CityPO po=cityDataService.findCity(name);
			vo=new CityVO(po.getName(), po.getZone());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			vo=null;
			System.out.println("findcity fail");
		}
		
		return vo;
	}
}
