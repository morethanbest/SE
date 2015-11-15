package businesslogic.commoditybl;

import java.rmi.RemoteException;

import vo.StockExaminationVO;
import businesslogicservice.commodityblservice.StockExaminationBlService;

public class StockExaminationController implements StockExaminationBlService{

	

	@Override
	public StockExaminationVO StockExamination(long startTime, long endTime)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
