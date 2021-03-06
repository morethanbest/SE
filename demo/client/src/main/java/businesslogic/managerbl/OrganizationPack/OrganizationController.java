package businesslogic.managerbl.OrganizationPack;

import java.util.List;

import businesslogic.userbl.UsersPack.FindOrgByCode;
import businesslogicservice.managerblservice.OrganizationBlService;
import po.Organizationtype;
import po.ResultMessage;
import vo.OrganizationVO;

public class OrganizationController implements OrganizationBlService {

	@Override
	public ResultMessage addOrganization(OrganizationVO vo){
		AddOrganization addo=new AddOrganization();
		Organization o=new Organization(addo);
		ResultMessage result=o.addOrganization(vo);
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public ResultMessage delOrganization(OrganizationVO vo){
		// TODO Auto-generated method stub
		DelOrganization delo=new DelOrganization();
		Organization o=new Organization(delo); 
		ResultMessage result=o.deleteOrganization(vo);
		return result;
	}

	@Override
	public ResultMessage revOrganization(OrganizationVO vo){
		// TODO Auto-generated method stub
		RevOrganization revo=new RevOrganization();
		Organization o= new Organization(revo);
		ResultMessage result=o.revOrganization(vo);
		return result;
	}

	@Override
	public List<OrganizationVO> getOrganizationbyCity(String city){
		// TODO Auto-generated method stub
		FindOrganization findo=new FindOrganization();
		Organization o=new Organization(findo);
		List<OrganizationVO> listvo=o.findOrganizationbyCity(city);
		return listvo;
	}

	@Override
	public List<OrganizationVO> getOrganizationbyType(Organizationtype type){
		// TODO Auto-generated method stub
		FindOrganization findo=new FindOrganization();
		Organization o=new Organization(findo);
		List<OrganizationVO> listvo=o.findOrganizationbyType(type);
		return listvo;
	}

	@Override
	public List<OrganizationVO> getOrganizationbyBoth(String city, Organizationtype type){
		// TODO Auto-generated method stub
		FindOrganization findo=new FindOrganization();
		Organization o=new Organization(findo);
		List<OrganizationVO> listvo=o.findOrganizationbyBoth(city, type);
		return listvo;
	}

	@Override
	public List<OrganizationVO> getOrganizationAll(){
		// TODO Auto-generated method stub
		FindOrganization findo=new FindOrganization();
		Organization o=new Organization(findo);
		List<OrganizationVO> listvo=o.findOrganizationall();
		return listvo;
	}

	@Override
	public String getOrganizationCode(String city, Organizationtype type){
		// TODO Auto-generated method stub
		GetOrganizationcode getcode=new GetOrganizationcode();
		Organization o=new Organization(getcode);
		String code=o.getorganizationcode(type,city);
		return code;
	}
	@Override
	public OrganizationVO findOrgByCode(String orgcode){
		// TODO Auto-generated method stub
		FindOrgByCode findOrgByCode=new FindOrgByCode();
		OrganizationVO vo=findOrgByCode.findOrgByCode(orgcode);
		return vo;
	}

}
