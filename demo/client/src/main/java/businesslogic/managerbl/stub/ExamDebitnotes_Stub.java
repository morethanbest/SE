package businesslogic.managerbl.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import businesslogicservice.managerblservice.ExamDebitnotes;
import vo.DebitnoteExamVO;
import vo.ResultMessage;

public class ExamDebitnotes_Stub implements ExamDebitnotes {

	@Override
	public List<DebitnoteExamVO> getDebitnotes() throws RemoteException {
		// TODO Auto-generated method stub
		List<DebitnoteExamVO> l=new ArrayList<DebitnoteExamVO>();
		l.add(new DebitnoteExamVO(1,1,"1","1","1",1,"1"));
		return l;
	}

	@Override
	public ResultMessage DebitnotesExam(List<DebitnoteExamVO> volist) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

}
