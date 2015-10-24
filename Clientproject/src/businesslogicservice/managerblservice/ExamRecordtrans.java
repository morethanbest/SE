package businesslogicservice.managerblservice;

import java.rmi.RemoteException;

import java.util.List;

import vo.ResultMessage; 

import vo.RecordtranExamVO;

public interface ExamRecordtrans {
	public List<RecordtranExamVO> getRecordtrans()throws RemoteException;
	
	public ResultMessage RecordtransExam (List<RecordtranExamVO> volist)throws RemoteException;

}
