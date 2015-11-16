package businesslogic.commoditybl.StockExaminationPack;

import java.util.List;

import vo.CommodityOutVO;

public class FormGetterMock {
	List<CommodityOutVO> list;
	
	
	long stockoutnum;
	long stockinnum;
	long moneyin;
	long moneyout;
	long allstocknum;
	
	
	public FormGetterMock(List<CommodityOutVO> list,long stockoutnum,long stockinnum,long moneyin,long moneyout,long allstocknum) {
		// TODO Auto-generated constructor stub
		this.list=list;
		
		this.stockoutnum=stockoutnum;
		this.stockinnum=stockinnum;
		this.moneyin=moneyin;
		this.moneyout=moneyout;
		this.allstocknum=allstocknum;
	}
	


	public List<CommodityOutVO> getform(long startTime, long endTime){
		return this.list;
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
