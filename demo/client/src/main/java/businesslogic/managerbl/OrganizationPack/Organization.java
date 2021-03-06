package businesslogic.managerbl.OrganizationPack;

import java.util.List;

import po.Organizationtype;
import po.ResultMessage;
import vo.OrganizationVO;

public class Organization {
	AddOrganization addo;
	FindOrganization findo;
	DelOrganization delo;
	RevOrganization revo;
	GetOrganizationcode getcode;
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

	public Organization(GetOrganizationcode getcode){
		this.getcode=getcode;
	}

	public ResultMessage addOrganization(OrganizationVO vo){
		String name=vo.getName();
		String organizationcode=vo.getOrganizationcode();
		Organizationtype type=vo.getType();
		String city=vo.getCity();
		addo.setAddInfo(name, organizationcode, type, city);
		ResultMessage result=addo.addOrganization();
		return result;
	}
	
	public List<OrganizationVO> findOrganizationbyCity(String city){
		findo.setFindInfo(city);
		List<OrganizationVO> listvo=findo.findOrganizationbyCity();
		return listvo;
	}
	
	public List<OrganizationVO> findOrganizationbyType(Organizationtype type){
		findo.setFindInfo(type);
		List<OrganizationVO> listvo=findo.findOrganizationbyType();
		return listvo;
	}
	
	public List<OrganizationVO> findOrganizationbyBoth(String city, Organizationtype type){
		findo.setFindInfo(city, type);
		List<OrganizationVO> listvo=findo.findOrganizationbyBoth();
		return listvo;
	}

	public List<OrganizationVO> findOrganizationall(){
		List<OrganizationVO> listvo=findo.findOrganizationall();
		return listvo;
	}

	public ResultMessage deleteOrganization(OrganizationVO vo){
		String name=vo.getName();
		String organizationcode=vo.getOrganizationcode();
		Organizationtype type=vo.getType();
		String city=vo.getCity();
		delo.setDelInfo(name, organizationcode, type, city);
		ResultMessage result=delo.delete();
		return result;
	}
	
	public ResultMessage revOrganization(OrganizationVO vo){
		String name=vo.getName();
		String organizationcode=vo.getOrganizationcode();
		Organizationtype type=vo.getType();
		String city=vo.getCity();
		revo.setRevInfo(name, organizationcode, type, city);
		ResultMessage result=revo.rev();
		return result;
	}

	public String getorganizationcode(Organizationtype type, String city){
        getcode.setGetcodeInfo(city,type);
		String result=getcode.getOrganizationcode();
		return result;
	}
}
