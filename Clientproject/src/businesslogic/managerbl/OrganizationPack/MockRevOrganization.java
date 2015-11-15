package businesslogic.managerbl.OrganizationPack;

import po.OrganizationPO;
import po.Organizationtype;
import vo.ResultMessage;

public class MockRevOrganization extends RevOrganization{
	String name;
	Organizationtype type;
	public void setRevInfo(String name,Organizationtype type){
		this.type=type;
		this.name=name;
	}
	
	public ResultMessage rev(){
		OrganizationPO po=new OrganizationPO(5,name,type);		//以后为从数据层拿，再删去
		long id=po.getId();
		OrganizationPO newpo=new OrganizationPO(id,name,type);
		ResultMessage result=ResultMessage.success;
		return result;
		
	}
}
