package businesslogicservice.managerblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.ResultMessage;
import po.StockoutPO;
import vo.StockoutExamVO;
import vo.StockoutVO;

public interface ExamStockouts {
	public List<StockoutVO> getStockoutForm (Formstate state);

	public ResultMessage updateStockoutForm (StockoutVO vo);
}
