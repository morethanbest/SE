package vo;

import java.util.List;

public class StocktakingVO {
	List<CommodityOutVO> list;

	public StocktakingVO(List<CommodityOutVO> list) {
		super();
		this.list = list;
	}

	public List<CommodityOutVO> getList() {
		return list;
	}
	
}
