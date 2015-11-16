package businesslogic.managerbl.OrganizationPack;

import po.OrganizationPO;
import po.Organizationtype;
import vo.ResultMessage;

public class MockAddOrganization extends AddOrganization{
	long id;
	String name;
	Organizationtype type;
	
	public void setAddInfo(long id,String name,Organizationtype type){
		this.id=id;
		this.name=name;
		this.type=type;
	}
	public ResultMessage addOrganization(){
		OrganizationPO po=new OrganizationPO(id,name,type);
		ResultMessage result=ResultMessage.success;
		return result;
	}
}
