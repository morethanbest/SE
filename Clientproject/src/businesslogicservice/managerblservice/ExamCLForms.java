package businesslogicservice.managerblservice;

import java.rmi.RemoteException;

import java.util.List;

import vo.ResultMessage; 

import vo.CLFormsExamVO;

public interface ExamCLForms {
	public List<CLFormsExamVO> getCLForms ()throws RemoteException;
	
	public ResultMessage CLFormsExam (List< CLFormsExamVO> volist)throws RemoteException;

}
