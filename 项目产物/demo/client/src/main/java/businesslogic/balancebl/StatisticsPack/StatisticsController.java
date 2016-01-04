package businesslogic.balancebl.StatisticsPack;

import java.rmi.RemoteException;

import vo.StatisticsVO;

public class StatisticsController implements businesslogicservice.balanceblservice.StatisticsBlService {
	@Override
	public StatisticsVO Statistics(long startTime, long endTime)  {
		// TODO Auto-generated method stub
		PayGet pay=new PayGet();
		CollectGet collect=new CollectGet();
		BalanceStatistics sta=new BalanceStatistics(collect,pay);
		StatisticsVO vo=sta.dosta(startTime,endTime);
		return vo;
	}
}
