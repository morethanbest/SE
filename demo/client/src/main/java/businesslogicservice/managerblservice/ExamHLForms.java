package businesslogicservice.managerblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.ResultMessage;
import vo.HLFormsExamVO;

public interface ExamHLForms {
	public List<HLFormsExamVO> getHLForms ()throws RemoteException;
	
	public ResultMessage HLFormsExam (List< HLFormsExamVO> volist)throws RemoteException;

}
