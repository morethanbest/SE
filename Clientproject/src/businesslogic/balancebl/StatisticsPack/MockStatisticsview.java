package businesslogic.balancebl.StatisticsPack;

import java.util.ArrayList;
import java.util.List;

import vo.DebitnoteVO;
import vo.RecordpayVO;
import vo.StatisticsVO;

public class MockStatisticsview {
	long startTime;
	long endTime;
	public void setStatistics(long startTime,long endTime){
		this.startTime=startTime;
		this.endTime=endTime;
	}
	public StatisticsVO getStatistics(){
		List<RecordpayVO> list1=new ArrayList<RecordpayVO>();
		List<DebitnoteVO> list2=new ArrayList<DebitnoteVO>();
		list1.add(new RecordpayVO(20151021, 100, "ss", 100, 0, 0, 0, 0, ""));
		list2.add(new DebitnoteVO(20150112, "", "", "", 100, null));
		StatisticsVO vo=new StatisticsVO(startTime, endTime, list1, list2);
		return vo;
	}
}
