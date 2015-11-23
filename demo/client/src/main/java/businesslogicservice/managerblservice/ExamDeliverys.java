package businesslogicservice.managerblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.ResultMessage;
import vo.DeliveryExamVO;

public interface ExamDeliverys {
	public List<DeliveryExamVO> getDeliverys()throws RemoteException;
	
	public ResultMessage DeliverysExam (List<DeliveryExamVO> volist)throws RemoteException;

}
