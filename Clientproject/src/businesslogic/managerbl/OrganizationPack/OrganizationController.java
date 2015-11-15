package businesslogic.managerbl.OrganizationPack;

import java.rmi.RemoteException;

import businesslogicservice.managerblservice.OrganizationBlService;
import vo.OrganizationVO;
import vo.ResultMessage;

public class OrganizationController implements OrganizationBlService {

	@Override
	public ResultMessage addOrganization(OrganizationVO vo) throws RemoteException {
		AddOrganization addo=new AddOrganization();
		IdInfo id=new IdInfo(5);
		Organization o=new Organization(addo,id);
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
	public OrganizationVO getOrganization(String name) throws RemoteException {
		// TODO Auto-generated method stub
		FindOrganization findo=new FindOrganization();
		Organization o=new Organization(findo);
		OrganizationVO vo=o.findOrganization(name);
		return vo;
	}

}