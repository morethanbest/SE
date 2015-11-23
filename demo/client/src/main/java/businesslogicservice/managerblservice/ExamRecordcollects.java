package businesslogicservice.managerblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.ResultMessage;
import vo.RecordcollectExamVO;

public interface ExamRecordcollects {
	public List<RecordcollectExamVO> getRecordcollects()throws RemoteException;
	
	public ResultMessage RecordcollectsExam (List<RecordcollectExamVO> volist)throws RemoteException;
}
