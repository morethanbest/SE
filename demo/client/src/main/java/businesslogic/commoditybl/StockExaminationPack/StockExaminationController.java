package businesslogic.commoditybl.StockExaminationPack;

import java.rmi.RemoteException;

import vo.StockExaminationVO;
import businesslogicservice.commodityblservice.StockExaminationBlService;

public class StockExaminationController implements StockExaminationBlService{

	

	@Override
	public StockExaminationVO StockExamination(long startTime, long endTime)
			throws RemoteException {
		// TODO Auto-generated method stub
		FormGetterMock formget=new FormGetterMock(null,0,0,0,0,0);///修改传入参数
		StockExamination exam=new StockExamination(formget);
		StockExaminationVO vos=exam.examhandle(startTime, endTime);
		return vos;
	}

}
