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

	public List<CityVO> getALLCity();

	public List<OrganizationVO> getAllOrganization(String city);

	public DebitnoteVO getRecordcollectbyhall(String orgcode);

	public DebitnoteVO getRecordcollectbydate(long date);

	public DebitnoteExamVO examcollect(DebitnoteVO vo);

}
