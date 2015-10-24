package businesslogicservice.managerblservice;

import java.rmi.RemoteException;

import java.util.List;

import vo.ResultMessage; 

import vo.DeliveryExamVO;

public interface ExamDeliverys {
	public List<DeliveryExamVO> getDeliverys()throws RemoteException;
	
	public ResultMessage DeliverysExam (List<DeliveryExamVO> volist)throws RemoteException;

}
