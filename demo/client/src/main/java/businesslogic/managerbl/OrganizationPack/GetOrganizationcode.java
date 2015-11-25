package businesslogic.managerbl.OrganizationPack;

import dataservice.managerdataservice.OrganizationDataService;
import init.RMIHelper;
import po.City;
import po.Organizationtype;

import java.rmi.RemoteException;

/**
 * Created by ³¬ on 2015/11/25.
 */
public class GetOrganizationcode {
    City city;
    Organizationtype type;
    public void setGetcodeInfo(City city, Organizationtype type){
        this.city=city;
        this.type=type;
    }

    public String getOrganizationcode(){
        String code=city.getNumber();
        if(type==Organizationtype.hall){
            OrganizationDataService organization= RMIHelper.getOrgdata();
            try {
                int number=Integer.parseInt(organization.getlasthallcode(city))+1;
                String s=Integer.toString(number);
                for(int i=0;i<3-s.length();i++){
                    code+="0";
                }
                code+=s;
            } catch (Exception e) {
                System.out.println("getcode fail");
            }
        }
        else{
            code+="0";
        }
        return code;
    }

}
