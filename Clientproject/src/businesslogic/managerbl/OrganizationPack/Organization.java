package businesslogic.managerbl.OrganizationPack;

import java.rmi.RemoteException;
import java.util.List;

import po.Organizationtype;
import vo.OrganizationVO;
import vo.ResultMessage;

public class Organization {
	AddOrganization addo;
	FindOrganization findo;
	DelOrganization delo;
	RevOrganization revo;
	public Organization(AddOrganization addo){
		this.addo=addo;
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
		long id=vo.getId();
		String name=vo.getName();
		Organizationtype type=vo.getType();
		addo.setAddInfo(id, name, type);;
		ResultMessage result=addo.addOrganization();
		return result;
	}
	
	public List<OrganizationVO> findOrganizationbyName(String name){
		findo.setFindInfo(name);
		List<OrganizationVO> listvo=findo.findOrganizationbyName();
		return listvo;
	}
	
	public List<OrganizationVO> findOrganizationbyType(Organizationtype type){
		findo.setFindInfo(type);
		List<OrganizationVO> listvo=findo.findOrganizationbyType();
		return listvo;
	}
	
	public List<OrganizationVO> findOrganizationbyBoth(String name, Organizationtype type){
		findo.setFindInfo(name, type);
		List<OrganizationVO> listvo=findo.findOrganizationbyBoth();
		return listvo;
	}
	
	public ResultMessage deleteOrganization(OrganizationVO vo){
		long id=vo.getId();
		delo.setDelInfo(id);
		ResultMessage result=delo.delete();
		return result;
	}
	
	public ResultMessage revOrganization(OrganizationVO vo){
		long id=vo.getId();
		String name=vo.getName();
		Organizationtype type=vo.getType();
		revo.setRevInfo(id,name, type);
		ResultMessage result=revo.rev();
		return result;
	}
}
