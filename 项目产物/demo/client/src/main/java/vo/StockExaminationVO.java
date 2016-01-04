package vo;

import java.util.List;

public class StockExaminationVO {
	long startTime;
	long endTime;
	
	long stockoutnum;
	long stockinnum;

	long allstocknum;
	
	
	List<CommodityExamVO> list;


	public StockExaminationVO(long startTime, long endTime,
							  long stockoutnum,long stockinnum,long allstocknum,List<CommodityExamVO> list) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.list = list;
		this.stockoutnum=stockoutnum;
		this.stockinnum=stockinnum;

		this.allstocknum=allstocknum;
	}


	public long getStartTime() {
		return startTime;
	}
	public long getEndTime() {
		return endTime;
	}
	public List<CommodityExamVO> getList() {
		return list;
	}
	
	
	public long getstockoutnum(){
		return stockoutnum;
	}
public long getstocinnum(){
		return stockinnum;
	}

public long getallstocknum(){
	return allstocknum;
}
}
