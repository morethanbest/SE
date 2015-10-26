package businesslogic.managerbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import businesslogicservice.managerblservice.Statistics;
import vo.DebitnoteVO;
import vo.RecordpayVO;
import vo.StatisticsVO;

public class Statistics_Stub implements Statistics {

	@Override
	public StatisticsVO getStatistics(long startTime, long endTime) throws RemoteException {
		// TODO Auto-generated method stub
		List<RecordpayVO> l1=new ArrayList<RecordpayVO>();
		l1.add(new RecordpayVO(1,1,"a",1,1,1,1,1,"b"));
		List<DebitnoteVO> l2=new ArrayList<DebitnoteVO>();
		l2.add(new DebitnoteVO(1,"a","a","a",1,"a"));
		
		return new StatisticsVO(1,1,l1,l2);
	}

}
