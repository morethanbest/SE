package vo;

import java.util.List;

public class RegionInfoVO {
	List<CommodityGetRegionVO> list;

	public RegionInfoVO(List<CommodityGetRegionVO> list) {
		super();
		this.list = list;
	}

	public List<CommodityGetRegionVO> getList() {
		return list;
	}
	
}
