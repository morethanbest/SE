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
		StockExaminationVO vo=new StockExaminationVO(startTime,endTime,list);
		return vo;
	}

}
