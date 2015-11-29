package businesslogic.managerbl.OrganizationPack;

import dataservice.managerdataservice.CityDataService;
import dataservice.managerdataservice.OrganizationDataService;
import init.RMIHelper;
import po.CityPO;
import po.Organizationtype;

/**
 * Created by �� on 2015/11/25.
 */
public class GetOrganizationcode {
	String city;
    Organizationtype type;
    public void setGetcodeInfo(String city, Organizationtype type){
        this.city=city;
        this.type=type;
    }

    public String getOrganizationcode(){
    	CityDataService cityDataService=RMIHelper.getCitydata();
    	String code = "";
    	try {
			CityPO po=cityDataService.findCity(city);
			code+=po.getZone();
			if(type==Organizationtype.hall){
	            OrganizationDataService organization= RMIHelper.getOrgdata();
	            int number=Integer.parseInt(organization.getlasthallcode(city))+1;
	            String s=Integer.toString(number);
	            for(int i=0;i<3-s.length();i++){
	                code+="0";
	            }
	            code+=s;
	        }
	        else{
	            code+="0";
	        }
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println("getorganizationcode fail");
		}
        
        return code;
    }

}
