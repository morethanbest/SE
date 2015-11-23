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
	
	public RegionInfoVO getinfo(long blocknum){
		List<CommodityInVO> list=regiongetter.getInfo(blocknum);
		RegionInfoVO vo=new RegionInfoVO(list);
		return vo;
		
		
		
	}
	
	

}
