package businesslogic.managerbl.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.Hall;
import vo.CLFormsExamVO;
import vo.ResultMessage;

public class ExamCLForms_Stub implements businesslogicservice.managerblservice.ExamCLForms {

	@Override
	public List<CLFormsExamVO> getCLForms() throws RemoteException {
		// TODO Auto-generated method stub
		List<String> s=new ArrayList<String>();
		s.add("1");
		List<CLFormsExamVO> l=new ArrayList<CLFormsExamVO>();
		l.add(new CLFormsExamVO(1,"1",Hall.Nanjing,"1","1","1",s,1));
		return l;
	}

	@Override
	public ResultMessage CLFormsExam(List<CLFormsExamVO> volist) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

}
