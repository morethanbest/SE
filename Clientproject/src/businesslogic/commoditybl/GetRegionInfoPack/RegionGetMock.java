package businesslogic.commoditybl.GetRegionInfoPack;
import vo.Region;
import java.util.List;

import vo.CommodityInVO;
public class RegionGetMock {
	List<CommodityInVO> list;
	public RegionGetMock(List<CommodityInVO> list) {
		// TODO Auto-generated constructor stub
		this.list=list;
	}
	
	
	
	
	public List<CommodityInVO> getInfo(long blocknum){
		return list;
	}
	
	
	
	
	

}
