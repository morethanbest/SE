package businesslogic.managerbl.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import businesslogicservice.managerblservice.ExamStockouts;
import po.Hall;
import po.Loadform;
import vo.ResultMessage;
import vo.StockoutExamVO;

public class ExamStockouts_Stub implements ExamStockouts {

	@Override
	public List<StockoutExamVO> getStockouts() throws RemoteException {
		// TODO Auto-generated method stub
		List<StockoutExamVO> l=new ArrayList<StockoutExamVO>();
		l.add(new StockoutExamVO(1,"1",1,Hall.Nanjing,Loadform.plane,"1","1"));
		return l;
	}

	@Override
	public ResultMessage StockoutsExam(List<StockoutExamVO> volist) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

}
