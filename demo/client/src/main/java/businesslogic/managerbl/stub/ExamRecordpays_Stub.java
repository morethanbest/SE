package businesslogic.managerbl.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import businesslogicservice.managerblservice.ExamRecordpays;
import vo.RecordpayExamVO;
import vo.ResultMessage;

public class ExamRecordpays_Stub implements ExamRecordpays {

	@Override
	public List<RecordpayExamVO> getRecordpays() throws RemoteException {
		// TODO Auto-generated method stub
		List<RecordpayExamVO> l=new ArrayList<RecordpayExamVO>();
		l.add(new RecordpayExamVO(1,1,"1",1,1,1,1,1,"1"));
		return l;
	}

	@Override
	public ResultMessage RecordpaysExam(List<RecordpayExamVO> volist) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

}
