package businesslogic.managerbl.OrganizationPack;

import po.OrganizationPO;
import po.Organizationtype;
import vo.ResultMessage;

public class DelOrganization {
	String name;
	Organizationtype type;
	public void setDelInfo(String name,Organizationtype type){
		this.type=type;
		this.name=name;
	}
	
	public ResultMessage delete(){
		OrganizationPO po=new OrganizationPO(5,name,type);		//以后为从数据层拿，再删去
		
		ResultMessage result=ResultMessage.success;
		return result;
		
	}
	
}
