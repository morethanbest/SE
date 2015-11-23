package businesslogicservice.managerblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.ResultMessage;
import vo.ArrivalExamVO;

public interface ExamArrivals {
	public List<ArrivalExamVO> getArrivals()throws RemoteException;
	
	public ResultMessage ArrivalsExam (List<ArrivalExamVO> volist)throws RemoteException;

}
