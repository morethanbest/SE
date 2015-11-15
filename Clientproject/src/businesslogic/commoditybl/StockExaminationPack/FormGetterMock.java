package businesslogic.commoditybl.StockExaminationPack;

import java.util.List;

import vo.CommodityOutVO;

public class FormGetterMock {
	List<CommodityOutVO> list;
	public FormGetterMock(List<CommodityOutVO> list) {
		// TODO Auto-generated constructor stub
		this.list=list;
	}
	
	public List<CommodityOutVO> getform(long startTime, long endTime){
		return this.list;
	}
	
	
	

}
