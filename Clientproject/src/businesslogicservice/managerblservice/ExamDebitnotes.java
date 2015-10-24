package businesslogicservice.managerblservice;

import java.rmi.RemoteException;

import java.util.List;

import vo.ResultMessage; 

import vo.DebitnoteExamVO;

public interface ExamDebitnotes {
	public List<DebitnoteExamVO> getDebitnotes()throws RemoteException;
	
	public ResultMessage DebitnotesExam (List<DebitnoteExamVO> volist)throws RemoteException;
}
