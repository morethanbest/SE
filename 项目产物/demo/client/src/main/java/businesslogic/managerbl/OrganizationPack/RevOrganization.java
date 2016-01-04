package businesslogic.managerbl.OrganizationPack;

import dataservice.managerdataservice.OrganizationDataService;
import init.RMIHelper;
import po.OrganizationPO;
import po.Organizationtype;
import po.ResultMessage;

public class RevOrganization {
	String name;
	String organizationcode;
	Organizationtype type;
	String city;
	public void setRevInfo(String name, String organizationcode, Organizationtype type, String city){
		this.name=name;
		this.organizationcode=organizationcode;
		this.type=type;
		this.city=city;
	}
	
	public ResultMessage rev(){
		OrganizationDataService organization=RMIHelper.getOrgdata();
		OrganizationPO newpo=new OrganizationPO(name, organizationcode, type, city);
		ResultMessage result;
		try {
			result = organization.updateOrganization(newpo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result=ResultMessage.failure;
			System.out.println("revorganization fail");
		}
		return result;
		
	}
}
