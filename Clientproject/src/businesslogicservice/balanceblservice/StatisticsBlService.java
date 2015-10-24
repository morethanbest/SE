package businesslogicservice.balanceblservice;

import java.rmi.RemoteException;

import vo.StatisticsVO;

public interface StatisticsBlService {
	public StatisticsVO Statistics(long startTime,long endTime)throws RemoteException;
}
