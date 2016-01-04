package businesslogic.commoditybl.GetRegionInfoPack;

import java.util.ArrayList;
import java.util.List;

import po.CommodityLocation;
import po.CommodityPO;
import vo.CommodityGetRegionVO;
import vo.RegionInfoVO;

public class GetRegionInfo {
		RegionGet getter;
	public GetRegionInfo(RegionGet getter){this.getter=getter;}
	
	public RegionInfoVO getinfo(String orgcode,long blocknum){
		List<CommodityPO> pos=getter.getcommodity(orgcode,blocknum);
		List<CommodityGetRegionVO> list=new ArrayList<CommodityGetRegionVO>();
		for(int i=0;i<=pos.size()-1;i++){
			CommodityPO po=pos.get(i);
			String ordercode=po.getOrdercode();
			long intime=po.getIntime();

			CommodityLocation location=po.getLocation();
			CommodityGetRegionVO newvo=new CommodityGetRegionVO(ordercode,intime,location);
			list.add(newvo);
		}

		RegionInfoVO vo=new RegionInfoVO(list);
		return vo;
		
		
		
	}
	
	

}
