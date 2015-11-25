package businesslogic.managerbl.OrganizationPack;

import dataservice.managerdataservice.OrganizationDataService;
import init.RMIHelper;
import po.City;
import po.OrganizationPO;
import po.Organizationtype;
import po.ResultMessage;

public class AddOrganization {
	String name;
	String organizationcode;
	Organizationtype type;
	City city;

	public void setAddInfo(String name, String organizationcode, Organizationtype type, City city){
		this.name=name;
		this.organizationcode=organizationcode;
		this.type=type;
		this.city=city;
	}
	
	
	public ResultMessage addOrganization(){
		OrganizationDataService organization=RMIHelper.getOrgdata();
		OrganizationPO po=new OrganizationPO(name, organizationcode, type, city);
		ResultMessage result;
		try {
			result = organization.addOrganization(po);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result = ResultMessage.failure;
			System.out.println("addorganization fail");
		}
		return result;
	}
}
