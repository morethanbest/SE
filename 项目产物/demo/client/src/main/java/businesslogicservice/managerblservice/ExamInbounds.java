package businesslogicservice.managerblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.ResultMessage;
import po.StockinPO;
import vo.StockinExamVO;
import vo.StockinVO;

public interface ExamInbounds {
	public List<StockinVO> getStockinForm (Formstate state);

	public ResultMessage updateStockinForm (StockinVO vo);
}
