package businesslogic.managerbl.OrganizationPack;

import java.util.List;

import po.City;
import po.Organizationtype;
import po.ResultMessage;
import vo.OrganizationVO;

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
		String name=vo.getName();
		String organizationcode=vo.getOrganizationcode();
		Organizationtype type=vo.getType();
		City city=vo.getCity();
		addo.setAddInfo(name, organizationcode, type, city);
		ResultMessage result=addo.addOrganization();
		return result;
	}
	
	public List<OrganizationVO> findOrganizationbyCity(City city){
		findo.setFindInfo(city);
		List<OrganizationVO> listvo=findo.findOrganizationbyCity();
		return listvo;
	}
	
	public List<OrganizationVO> findOrganizationbyType(Organizationtype type){
		findo.setFindInfo(type);
		List<OrganizationVO> listvo=findo.findOrganizationbyType();
		return listvo;
	}
	
	public List<OrganizationVO> findOrganizationbyBoth(City city, Organizationtype type){
		findo.setFindInfo(city, type);
		List<OrganizationVO> listvo=findo.findOrganizationbyBoth();
		return listvo;
	}
	
	public ResultMessage deleteOrganization(OrganizationVO vo){
		String name=vo.getName();
		String organizationcode=vo.getOrganizationcode();
		Organizationtype type=vo.getType();
		City city=vo.getCity();
		delo.setDelInfo(name, organizationcode, type, city);
		ResultMessage result=delo.delete();
		return result;
	}
	
	public ResultMessage revOrganization(OrganizationVO vo){
		String name=vo.getName();
		String organizationcode=vo.getOrganizationcode();
		Organizationtype type=vo.getType();
		City city=vo.getCity();
		revo.setRevInfo(name, organizationcode, type, city);
		ResultMessage result=revo.rev();
		return result;
	}
}
