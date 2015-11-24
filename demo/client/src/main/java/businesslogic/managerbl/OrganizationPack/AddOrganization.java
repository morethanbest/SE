package businesslogic.managerbl.OrganizationPack;

import dataservice.managerdataservice.OrganizationDataService;
import init.RMIHelper;
import po.OrganizationPO;
import po.Organizationtype;
import po.ResultMessage;

public class AddOrganization {
	long id;
	String name;
	Organizationtype type;
	
	public void setAddInfo(long id,String name,Organizationtype type){
		this.id=id;
		this.name=name;
		this.type=type;
	}
	
	
	public ResultMessage addOrganization(){
		OrganizationDataService organization=RMIHelper.getOrgdata();
		OrganizationPO po=new OrganizationPO(id,name,type);
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
