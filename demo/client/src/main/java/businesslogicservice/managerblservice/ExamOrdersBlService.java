package businesslogicservice.managerblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.OrderPO;
import po.ResultMessage;
import vo.OrderExamVO;
import vo.OrderVO;

public interface ExamOrdersBlService {
	public List<OrderVO> getOrderForm (Formstate state);

	public ResultMessage updateOrderForm (OrderVO vo);
}
