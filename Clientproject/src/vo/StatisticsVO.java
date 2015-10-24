package vo;

import java.util.List;

public class StatisticsVO {
	long startTime;
	long endTime;
	List<RecordpayVO> list1;
	List<DebitnoteVO> list2;
	public StatisticsVO(long startTime, long endTime, List<RecordpayVO> list1,
			List<DebitnoteVO> list2) {
		super();
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
	public List<DebitnoteVO> getList2() {
		return list2;
	}
	
}
