package businesslogic.managerbl.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import vo.DeliveryExamVO;
import vo.ResultMessage;

public class ExamDeliverys_Stub implements businesslogicservice.managerblservice.ExamDeliverys {

	@Override
	public List<DeliveryExamVO> getDeliverys() throws RemoteException {
		// TODO Auto-generated method stub
		List<DeliveryExamVO> l=new ArrayList<DeliveryExamVO>();
		l.add(new DeliveryExamVO(1,"1","1"));
		return l;
	}

	@Override
	public ResultMessage DeliverysExam(List<DeliveryExamVO> volist) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

}
