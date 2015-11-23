package businesslogicservice.managerblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.ResultMessage;
import vo.OrderExamVO;

public interface ExamOrdersBlService {
	public List<OrderExamVO> getOrders()throws RemoteException;
	
	public ResultMessage OrdersExam (List<OrderExamVO> volist)throws RemoteException;

}
