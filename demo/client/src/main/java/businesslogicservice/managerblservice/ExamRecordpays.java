package businesslogicservice.managerblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.ResultMessage;
import vo.RecordpayExamVO;

public interface ExamRecordpays {
	public List<RecordpayExamVO> getRecordpays()throws RemoteException;
	
	public ResultMessage RecordpaysExam (List<RecordpayExamVO> volist)throws RemoteException;
}
