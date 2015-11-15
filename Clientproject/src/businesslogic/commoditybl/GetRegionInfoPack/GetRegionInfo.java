package businesslogic.commoditybl.GetRegionInfoPack;

import java.util.List;

import vo.CommodityInVO;
import vo.Region;
import vo.RegionInfoVO;

public class GetRegionInfo {
		RegionGetMock regiongetter;
	public GetRegionInfo(RegionGetMock regiongetter) {
		// TODO Auto-generated constructor stub
		this.regiongetter=regiongetter;
		
	}
	
	public RegionInfoVO getinfo(Region region){
		List<CommodityInVO> list=regiongetter.getInfo(region);
		RegionInfoVO vo=new RegionInfoVO(list);
		return vo;
		
		
		
	}
	
	

}
