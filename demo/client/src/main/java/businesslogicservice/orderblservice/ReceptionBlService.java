package businesslogicservice.orderblservice;

import po.ResultMessage;
import vo.ReceptionVO;

public interface ReceptionBlService {
	public ResultMessage addReception (ReceptionVO vo);
}
