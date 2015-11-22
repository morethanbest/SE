package businesslogic.managerbl.OrganizationPack;

import java.rmi.RemoteException;
import java.util.List;

import po.Organizationtype;
import businesslogicservice.managerblservice.OrganizationBlService;
import vo.OrganizationVO;
import vo.ResultMessage;

public class OrganizationController implements OrganizationBlService {

	@Override
	public ResultMessage addOrganization(OrganizationVO vo) throws RemoteException {
		AddOrganization addo=new AddOrganization();
		IdInfo id=new IdInfo();
		Organization o=new Organization(addo);
		OrganizationVO newvo=new OrganizationVO(id.getid(), vo.getName(), vo.getType());
		ResultMessage result=o.addOrganization(vo);
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public ResultMessage delOrganization(OrganizationVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		DelOrganization delo=new DelOrganization();
		Organization o=new Organization(delo); 
		ResultMessage result=o.deleteOrganization(vo);
		return result;
	}

	@Override
	public ResultMessage revOrganization(OrganizationVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		RevOrganization revo=new RevOrganization();
		Organization o= new Organization(revo);
		ResultMessage result=o.revOrganization(vo);
		return result;
	}

	@Override
	public List<OrganizationVO> getOrganizationbyName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		FindOrganization findo=new FindOrganization();
		Organization o=new Organization(findo);
		List<OrganizationVO> listvo=o.findOrganizationbyName(name);
		return listvo;
	}

	@Override
	public List<OrganizationVO> getOrganizationbyType(Organizationtype type) throws RemoteException {
		// TODO Auto-generated method stub
		FindOrganization findo=new FindOrganization();
		Organization o=new Organization(findo);
		List<OrganizationVO> listvo=o.findOrganizationbyType(type);
		return listvo;
	}

	@Override
	public List<OrganizationVO> getOrganizationbyBoth(String name, Organizationtype type) throws RemoteException {
		// TODO Auto-generated method stub
		FindOrganization findo=new FindOrganization();
		Organization o=new Organization(findo);
		List<OrganizationVO> listvo=o.findOrganizationbyBoth(name, type);
		return listvo;
	}

}
