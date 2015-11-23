package businesslogic.managerbl.StatisticsPack;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import vo.DebitnoteVO;
import vo.RecordpayVO;
import vo.StatisticsVO;

public class StatisticsController implements businesslogicservice.balanceblservice.StatisticsBlService {
	@Override
	public StatisticsVO Statistics(long startTime, long endTime) throws RemoteException {
		// TODO Auto-generated method stub
		List<RecordpayVO> l1=new ArrayList<RecordpayVO>();
		l1.add(new RecordpayVO(20150522,100,"a","10050",4020,500,6400,1000,"mark"));
		List<DebitnoteVO> l2=new ArrayList<DebitnoteVO>();
		l2.add(new DebitnoteVO(20150522,"a","a","a",1,"office"));
		
		return new StatisticsVO(1,1,l1,l2);
	}
}
