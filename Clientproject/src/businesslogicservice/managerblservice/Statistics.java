package businesslogicservice.managerblservice;

import java.rmi.RemoteException;

import vo.StatisticsVO;

public interface Statistics {
	public StatisticsVO getStatistics(long startTime,long endTime)throws RemoteException;

}
