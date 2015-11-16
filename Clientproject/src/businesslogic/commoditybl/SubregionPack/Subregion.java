package businesslogic.commoditybl.SubregionPack;

import po.CommodityLocation;
import po.CommodityPO;
import vo.ResultMessage;

public class Subregion {
	SubRegionMock mock;
	public Subregion(SubRegionMock mock) {
		// TODO Auto-generated constructor stub
		this.mock=mock;
	}
	
	
	public ResultMessage sub(CommodityLocation bef,CommodityLocation aft){
		CommodityPO po=mock.getpo(bef);
		long id=po.getId();
		String ordercode=po.getOrdercode();
		long intime=po.getIntime();
		CommodityLocation location=aft;
		long outtime=po.getOuttime();
		
		CommodityPO newpo=new CommodityPO(id, ordercode, intime, location, outtime);
		ResultMessage result=mock.passnewcom(newpo);
		return result;
	}
	
	

}
