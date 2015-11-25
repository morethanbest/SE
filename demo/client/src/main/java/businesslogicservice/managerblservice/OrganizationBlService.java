package businesslogicservice.managerblservice;

import java.util.List;

import po.City;
import po.Organizationtype;
import po.ResultMessage;
import vo.OrganizationVO;

public interface OrganizationBlService {
	public ResultMessage addOrganization (OrganizationVO vo);
	
	public ResultMessage delOrganization(OrganizationVO vo);
	
	public ResultMessage revOrganization (OrganizationVO vo);

	public List<OrganizationVO> getOrganizationbyCity(City city);

	public List<OrganizationVO> getOrganizationbyType(Organizationtype type);

	public List<OrganizationVO> getOrganizationbyBoth(City city, Organizationtype type);
}
