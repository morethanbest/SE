package businesslogic.managerbl.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import businesslogicservice.managerblservice.ExamOrdersBlService;
import po.Ordertype;
import vo.OrderExamVO;
import vo.ResultMessage;

public class ExamOrdersBlService_Stub implements ExamOrdersBlService {

	@Override
	public List<OrderExamVO> getOrders() throws RemoteException {
		// TODO Auto-generated method stub
		List<OrderExamVO> l=new ArrayList<OrderExamVO>();
		l.add(new OrderExamVO(1,"1","1","1","1","1","1","1","1","1","1",1,1,1,"1",1,1,"1",Ordertype.economical));
		return l;
	}

	@Override
	public ResultMessage OrdersExam(List<OrderExamVO> volist) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

}
