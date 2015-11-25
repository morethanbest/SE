package businesslogic.managerbl.OrganizationPack;

import dataservice.managerdataservice.OrganizationDataService;
import init.RMIHelper;
import po.City;
import po.OrganizationPO;
import po.Organizationtype;
import po.ResultMessage;

public class DelOrganization {
	String name;
	String organizationcode;
	Organizationtype type;
	City city;
	public void setDelInfo(String name, String organizationcode, Organizationtype type, City city){
		this.name=name;
		this.organizationcode=organizationcode;
		this.type=type;
		this.city=city;
	}
	
	public ResultMessage delete(){
		OrganizationDataService organization=RMIHelper.getOrgdata();
		OrganizationPO po=new OrganizationPO(name, organizationcode, type, city);
		ResultMessage result;
		try {
			result=organization.deleteOrganization(po);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result=ResultMessage.failure;
			System.out.println("deleteorganization fail");
		}
		return result;
		
	}
}
