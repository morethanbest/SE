package businesslogic.managerbl.stub;

import java.rmi.RemoteException;

import businesslogicservice.managerblservice.OrganizationBlService;
import po.Organizationtype;
import vo.OrganizationVO;
import vo.ResultMessage;

public class OrganizationBlService_Stub implements OrganizationBlService {

	@Override
	public ResultMessage addOrganization(OrganizationVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

	@Override
	public ResultMessage delOrganization(OrganizationVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

	@Override
	public ResultMessage revOrganization(OrganizationVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

	@Override
	public OrganizationVO getOrganization(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return new OrganizationVO("1",Organizationtype.hall);
	}

}
