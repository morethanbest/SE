package vo;

import java.util.List;

public class StockExaminationVO {
	long startTime;
	long endTime;
	
	long stockoutnum;
	long stockinnum;
	long moneyin;
	long moneyout;
	long allstocknum;
	
	
	List<CommodityOutVO> list;
	public StockExaminationVO(long startTime, long endTime,
			List<CommodityOutVO> list,long stockoutnum,long stockinnum,long moneyin,long moneyout,long allstocknum) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.list = list;
		this.stockoutnum=stockoutnum;
		this.stockinnum=stockinnum;
		this.moneyin=moneyin;
		this.moneyout=moneyout;
		this.allstocknum=allstocknum;
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
	
	
	public long getstockoutnum(){
		return stockoutnum;
	}
public long getstocinnum(){
		return stockinnum;
	}
public long getmoneyin(){
	return moneyin;
}
public long getmoneyout(){
	return moneyout;
}
public long getallstocknum(){
	return allstocknum;
}
}
