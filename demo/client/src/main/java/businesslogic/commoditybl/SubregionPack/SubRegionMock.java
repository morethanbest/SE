package businesslogic.commoditybl.SubregionPack;

import po.CommodityLocation;
import po.CommodityPO;
import vo.ResultMessage;

public class SubRegionMock {
	CommodityPO po;
	public SubRegionMock(CommodityPO po) {
		
		// TODO Auto-generated constructor stub
		this.po=po;
	}
	
	public CommodityPO getpo(CommodityLocation bef){
		return po;
	}
	
	public ResultMessage passnewcom(CommodityPO po){
		return ResultMessage.success;
	}
	
	

}
