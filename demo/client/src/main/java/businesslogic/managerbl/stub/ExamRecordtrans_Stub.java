package businesslogic.managerbl.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import businesslogicservice.managerblservice.ExamRecordtrans;
import po.Hall;
import vo.RecordtranExamVO;
import vo.ResultMessage;

public class ExamRecordtrans_Stub implements ExamRecordtrans {

	@Override
	public List<RecordtranExamVO> getRecordtrans() throws RemoteException {
		// TODO Auto-generated method stub
		List<RecordtranExamVO> l=new ArrayList<RecordtranExamVO>();
		List<String> s=new ArrayList<String>();
		s.add("a");
		l.add(new RecordtranExamVO(1,1,"1","1",Hall.Nanjing,Hall.Nanjing1,"1","1",s,0));
		return l;
	}

	@Override
	public ResultMessage RecordtransExam(List<RecordtranExamVO> volist) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

}
