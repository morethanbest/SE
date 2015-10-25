package vo;

import java.util.List;

public class StockExaminationVO {
	long startTime;
	long endTime;
	List<CommodityOutVO> list;
	public StockExaminationVO(long startTime, long endTime,
			List<CommodityOutVO> list) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.list = list;
	}
	public long getStartTime() {
		return startTime;
	}
	public long getEndTime() {
		return endTime;
	}
	public List<CommodityOutVO> getList() {
		return list;
	}
}
