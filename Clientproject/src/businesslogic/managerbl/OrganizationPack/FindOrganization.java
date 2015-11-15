package businesslogic.managerbl.OrganizationPack;

import po.OrganizationPO;
import po.Organizationtype;
import vo.OrganizationVO;
import vo.ResultMessage;

public class FindOrganization {
	
	String name;
	
	public void setFindInfo(String name){
		this.name=name;
	}
	public OrganizationVO findOrganization(){
		OrganizationPO po=new OrganizationPO(5,name,Organizationtype.hall);		//以后为从数据层拿
		Organizationtype type=po.getType();
		String name=po.getName();
		OrganizationVO vo=new OrganizationVO(name,type);
		return vo;
	}
}
