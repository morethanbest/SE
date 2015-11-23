package businesslogic.commoditybl.StockExaminationPack;

import java.util.List;

import vo.CommodityOutVO;
import vo.StockExaminationVO;

public class StockExamination {
	FormGetterMock getter;
	public StockExamination(FormGetterMock getter) {
		// TODO Auto-generated constructor stub
		this.getter=getter;
	}
	
	public StockExaminationVO examhandle(long startTime, long endTime){
		List<CommodityOutVO> list=getter.getform(startTime, endTime);
		long stockoutnum=getter.getallstocknum();
		long stockinnum=getter.getstocinnum();
		long moneyin=getter.getmoneyin();
		long moneyout=getter.getmoneyout();
		long allstocknum=getter.getallstocknum();
		StockExaminationVO vo=new StockExaminationVO(startTime,endTime,list,stockoutnum,stockinnum,moneyin,moneyout,allstocknum);
		return vo;
	}

}
