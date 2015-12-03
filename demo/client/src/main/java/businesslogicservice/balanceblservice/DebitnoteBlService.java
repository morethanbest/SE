package businesslogicservice.balanceblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.CityPO;
import po.OrganizationPO;
import po.RecordcollectPO;
import po.ResultMessage;
import vo.CityVO;
import vo.DebitnoteExamVO;
import vo.DebitnoteVO;
import vo.OrganizationVO;

public interface DebitnoteBlService {

	public List<CityVO> getALLCity()throws RemoteException;

	public List<OrganizationVO> getAllOrganization(String city)throws RemoteException;

	public DebitnoteVO getRecordcollectbyhall(String orgcode)throws RemoteException;

	public DebitnoteVO getRecordcollectbydate(long date)throws RemoteException;

	public DebitnoteExamVO examcollect(DebitnoteVO vo)throws  RemoteException;

}
