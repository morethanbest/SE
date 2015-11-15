package businesslogic.managerbl.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import businesslogicservice.managerblservice.ExamRecordcollects;
import vo.RecordcollectExamVO;
import vo.ResultMessage;

public class ExamRecordcollects_Stub implements ExamRecordcollects {

	@Override
	public List<RecordcollectExamVO> getRecordcollects() throws RemoteException {
		// TODO Auto-generated method stub
		List<RecordcollectExamVO> l=new ArrayList<RecordcollectExamVO>();
		List<String> s=new ArrayList<String>();
		s.add("a");
		l.add(new RecordcollectExamVO(1,1,1,"a",s));
		return l;
	}

	@Override
	public ResultMessage RecordcollectsExam(List<RecordcollectExamVO> volist) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

}
