package vo;

import java.util.List;

public class RegionInfoVO {
	List<CommodityInVO> list;

	public RegionInfoVO(List<CommodityInVO> list) {
		super();
		this.list = list;
	}

	public List<CommodityInVO> getList() {
		return list;
	}
	
}
