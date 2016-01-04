package vo;

import businesslogic.balancebl.RecordcollectPack.Recordcollect;
import po.RecordcollectPO;

import java.util.List;

public class StatisticsVO {
	long startTime;
	long endTime;
	List<RecordpayVO> list1;
	List<RecordcollectVO> list2;
	public StatisticsVO(long startTime, long endTime, List<RecordpayVO> list1,
			List<RecordcollectVO> list2) {

		this.startTime = startTime;
		this.endTime = endTime;
		this.list1 = list1;
		this.list2 = list2;
	}
	public long getStartTime() {
		return startTime;
	}
	public long getEndTime() {
		return endTime;
	}
	public List<RecordpayVO> getList1() {
		return list1;
	}
	public List<RecordcollectVO> getList2() {
		return list2;
	}
	
}
