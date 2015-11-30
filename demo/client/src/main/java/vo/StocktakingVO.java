package vo;

import java.util.List;

public class StocktakingVO {
	List<CommodityTakingVO> list;

	public StocktakingVO(List<CommodityTakingVO> list) {
		super();
		this.list = list;
	}

	public List<CommodityTakingVO> getList() {
		return list;
	}
	
}
