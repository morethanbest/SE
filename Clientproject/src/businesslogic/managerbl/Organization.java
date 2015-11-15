package businesslogic.managerbl;

import java.rmi.RemoteException;

import businesslogicservice.managerblservice.OrganizationBlService;
import vo.OrganizationVO;
import vo.ResultMessage;

public class Organization implements OrganizationBlService {

	@Override
	public ResultMessage addOrganization(OrganizationVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delOrganization(OrganizationVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage revOrganization(OrganizationVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrganizationVO getOrganization(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
