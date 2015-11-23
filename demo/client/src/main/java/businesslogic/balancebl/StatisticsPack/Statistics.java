package businesslogic.balancebl.StatisticsPack;

import vo.StatisticsVO;

public class Statistics {
	long startTime;
	long endTime;
	MockStatisticsview statisticsview=new MockStatisticsview();
	public Statistics(long startTime,long endTime){
		this.startTime=startTime;
		this.endTime=endTime;
	}
    public StatisticsVO getStatistics(){
    	statisticsview.setStatistics(startTime, endTime);
    	StatisticsVO vo=statisticsview.getStatistics();
    	return vo;
    }
}
