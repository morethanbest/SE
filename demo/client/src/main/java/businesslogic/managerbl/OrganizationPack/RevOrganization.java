package businesslogic.managerbl.OrganizationPack;

import dataservice.managerdataservice.OrganizationDataService;
import init.RMIHelper;
import po.OrganizationPO;
import po.Organizationtype;
import po.ResultMessage;

public class RevOrganization {
	long id;
	String name;
	Organizationtype type;
	public void setRevInfo(Long id, String name,Organizationtype type){
		this.id=id;
		this.type=type;
		this.name=name;
	}
	
	public ResultMessage rev(){
		OrganizationDataService organization=RMIHelper.getOrgdata();
		OrganizationPO newpo=new OrganizationPO(id,name,type);
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
