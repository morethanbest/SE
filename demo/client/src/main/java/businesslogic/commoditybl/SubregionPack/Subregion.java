package businesslogic.commoditybl.SubregionPack;

import po.CommodityLocation;
import po.CommodityPO;
import po.ResultMessage;

public class Subregion {
	ChangeLocation change;
	public Subregion(ChangeLocation change){
		this.change=change;
	}
	
	
	public ResultMessage sub(String orgcode,CommodityLocation bef,CommodityLocation aft){
		ResultMessage result=change.resultLoc(orgcode,bef,aft);
		return result;
	}
	
	

}
