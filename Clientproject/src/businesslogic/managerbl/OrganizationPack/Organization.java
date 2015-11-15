package businesslogic.managerbl.OrganizationPack;

import po.Organizationtype;
import vo.OrganizationVO;
import vo.ResultMessage;

public class Organization {
	AddOrganization addo;
	FindOrganization findo;
	DelOrganization delo;
	RevOrganization revo;
	IdInfo id;
	public Organization(AddOrganization addo,IdInfo id){
		this.addo=addo;
		this.id=id;
	}
	
	public Organization(FindOrganization findo){
		this.findo=findo;
	}
	
	public Organization(DelOrganization delo){
		this.delo=delo;
	}
	
	public Organization(RevOrganization revo){
		this.revo=revo;
	}
	
	public ResultMessage addOrganization(OrganizationVO vo){
		String name=vo.getName();
		Organizationtype type=vo.getType();
		long id=this.id.getid();
		addo.setAddInfo(id,name, type);;
		ResultMessage result=addo.addOrganization();
		return result;
	}
	
	public OrganizationVO findOrganization(String name){
		OrganizationVO vo;
		findo.setFindInfo(name);
		vo=findo.findOrganization();
		return vo;
	}
	
	public ResultMessage deleteOrganization(OrganizationVO vo){
		String name=vo.getName();
		Organizationtype type=vo.getType();
		delo.setDelInfo(name, type);
		ResultMessage result=delo.delete();
		return result;
	}
	
	public ResultMessage revOrganization(OrganizationVO vo){
		String name=vo.getName();
		Organizationtype type=vo.getType();
		revo.setRevInfo(name, type);
		ResultMessage result=revo.delete();
		return result;
	}
}
