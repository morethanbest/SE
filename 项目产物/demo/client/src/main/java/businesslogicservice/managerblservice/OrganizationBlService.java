package businesslogicservice.managerblservice;

import java.util.List;

import po.Organizationtype;
import po.ResultMessage;
import vo.OrganizationVO;

public interface OrganizationBlService {
	public ResultMessage addOrganization (OrganizationVO vo);
	
	public ResultMessage delOrganization(OrganizationVO vo);
	
	public ResultMessage revOrganization (OrganizationVO vo);

	public List<OrganizationVO> getOrganizationbyCity(String city);

	public List<OrganizationVO> getOrganizationbyType(Organizationtype type);

	public List<OrganizationVO> getOrganizationbyBoth(String city, Organizationtype type);

	public List<OrganizationVO> getOrganizationAll();

	public String getOrganizationCode(String city, Organizationtype type);

	public OrganizationVO findOrgByCode(String orgcode);
}
