package businesslogicservice.managerblservice;

import java.rmi.RemoteException;

import vo.ResultMessage; 

import java.util.List;

import vo.OrderExamVO;

public interface ExamOrdersBlService {
	public List<OrderExamVO> getOrders()throws RemoteException;
	
	public ResultMessage OrdersExam (List<OrderExamVO> volist)throws RemoteException;

}
