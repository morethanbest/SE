package businesslogicservice.commodityblservice;

import java.rmi.RemoteException;

import vo.StockExaminationVO;

public interface StockExaminationBlService {
	public StockExaminationVO StockExamination (String orgcode,long startTime, long endTime);
}