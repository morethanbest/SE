package businesslogicservice.managerblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.ArrivalPO;
import po.Formstate;
import po.ResultMessage;
import vo.ArrivalExamVO;
import vo.ArrivalVO;

public interface ExamArrivals {
	public List<ArrivalVO> getArrivalForm (Formstate state);

	public ResultMessage updateArrivalForm (ArrivalVO vo);

}
