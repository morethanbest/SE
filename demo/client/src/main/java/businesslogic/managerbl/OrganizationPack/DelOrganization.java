package businesslogic.managerbl.OrganizationPack;

import dataservice.managerdataservice.OrganizationDataService;
import init.RMIHelper;
import po.OrganizationPO;
import po.ResultMessage;

public class DelOrganization {
	long id;
	public void setDelInfo(long id){
		this.id=id;
	}
	
	public ResultMessage delete(){
		OrganizationDataService organization=RMIHelper.getOrgdata();
		OrganizationPO po;
		ResultMessage result;
		try {
			po = organization.findOrganization(id);
			result=organization.deleteOrganization(po);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result=ResultMessage.failure;
			System.out.println("delete fail");
		}
		return result;
		
	}
}
