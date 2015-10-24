package businesslogicservice.managerblservice;

import java.rmi.RemoteException;

import vo.StatisticsVO;

public interface Statistics {
	public StatisticsVO Statistics(long startTime,long endTime)throws RemoteException;

}
