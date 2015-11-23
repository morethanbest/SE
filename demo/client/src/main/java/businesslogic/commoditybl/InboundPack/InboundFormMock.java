package businesslogic.commoditybl.InboundPack;

import po.City;
import po.CommodityLocation;
import po.CommodityPO;
import po.StockinPO;
import vo.ResultMessage;

public class InboundFormMock {
	
	
	
	String ordercode;
	long intime;
	CommodityLocation location;
	City destination;
	long id;

	public void setInboundForm(String ordercode, long intime,CommodityLocation location,City destination,long id) {
		// TODO Auto-generated constructor stub
		this.ordercode=ordercode;
		this.intime=intime;
		this.location=location;
		this.destination=destination;
		this.id=id;
	}
	
	
	
	public ResultMessage passform(){
		StockinPO newpo=new StockinPO(id,ordercode,intime,location,destination);
		CommodityPO newcommodity=new CommodityPO(id,ordercode,intime,location,-1);
		
		ResultMessage result=ResultMessage.success;
		return result;
				
		
		
	}
	

}
