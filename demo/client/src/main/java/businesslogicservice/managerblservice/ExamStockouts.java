package businesslogicservice.managerblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.ResultMessage;
import vo.StockoutExamVO;

public interface ExamStockouts {
	public List<StockoutExamVO> getStockouts()throws RemoteException;
	
	public ResultMessage StockoutsExam (List<StockoutExamVO> volist)throws RemoteException;
}
