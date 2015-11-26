package businesslogic.managerbl.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import businesslogicservice.managerblservice.ExamHLForms;
import vo.HLFormsExamVO;
import vo.ResultMessage;

public class ExamHLForms_Stub implements ExamHLForms {

	@Override
	public List<HLFormsExamVO> getHLForms() throws RemoteException {
		// TODO Auto-generated method stub
		List<HLFormsExamVO> l=new ArrayList<HLFormsExamVO>();
		List<String> s=new ArrayList<String>();
		s.add("s");
		l.add(new HLFormsExamVO(1,"1","1",Hall.Nanjing,"1","1","1",s,1));
		return l;
	}

	@Override
	public ResultMessage HLFormsExam(List<HLFormsExamVO> volist) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

}
