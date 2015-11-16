package businesslogicservice.managerblservice;

import java.rmi.RemoteException;

import java.util.List;

import vo.ResultMessage; 

import vo.GoodsReceivingExamVO;

public interface ExamGoodsRecevings {
	public List<GoodsReceivingExamVO> getGoodsRecevings()throws RemoteException;
	
	public ResultMessage GoodsRecevingsExam (List<GoodsReceivingExamVO> volist)throws RemoteException;

}
