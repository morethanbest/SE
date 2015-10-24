package businesslogicservice.managerblservice;

import java.rmi.RemoteException;

import java.util.List;

import vo.ResultMessage; 

import vo.InboundExamVO;

public interface ExamInbounds {
	public List<InboundExamVO> getInbounds()throws RemoteException;
	
	public ResultMessage InboundsExam (List<InboundExamVO> volist)throws RemoteException;
}
