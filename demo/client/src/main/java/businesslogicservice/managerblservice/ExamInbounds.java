package businesslogicservice.managerblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.ResultMessage;
import vo.StockinExamVO;

public interface ExamInbounds {
	public List<StockinExamVO> getInbounds()throws RemoteException;
	
	public ResultMessage InboundsExam (List<StockinExamVO> volist)throws RemoteException;
}
