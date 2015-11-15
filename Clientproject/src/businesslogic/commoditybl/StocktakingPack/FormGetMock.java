package businesslogic.commoditybl.StocktakingPack;

import java.util.List;

import vo.CommodityOutVO;

public class FormGetMock {
	List<CommodityOutVO> list;
	public FormGetMock(List<CommodityOutVO> list) {
		// TODO Auto-generated constructor stub
		this.list=list;
	}
	
	
	
	public List<CommodityOutVO> getForm(){
		return this.list;
	}

}
