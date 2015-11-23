package businesslogicservice.commodityblservice;

import java.rmi.RemoteException;

import vo.StockExaminationVO;

public interface StockExaminationBlService {
	public StockExaminationVO StockExamination (long startTime, long endTime)throws RemoteException;
}