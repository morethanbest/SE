package businesslogicservice.managerblservice;

import java.rmi.RemoteException;

import java.util.List;

import vo.ResultMessage; 

import vo.GoodsRecevingExamVO;

public interface ExamGoodsRecevings {
	public List<GoodsRecevingExamVO> getGoodsRecevings()throws RemoteException;
	
	public ResultMessage GoodsRecevingsExam (List<GoodsRecevingExamVO> volist)throws RemoteException;

}
