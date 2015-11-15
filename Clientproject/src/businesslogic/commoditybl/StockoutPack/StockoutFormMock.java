package businesslogic.commoditybl.StockoutPack;

import po.CommodityPO;
import po.Hall;
import po.Loadform;
import po.StockoutPO;
import vo.ResultMessage;

public class StockoutFormMock {
	String ordercode;
	long outtime;
	Hall destination;
	Loadform loadform;
	String transcode;
	String motorcode;
	long id;
	
	
	
	
	public void setStockoutForm(String ordercode,long outtime,Hall destination,Loadform loadform,String transcode,String motorcode,long id) {
		// TODO Auto-generated constructor stub
		this.ordercode=ordercode;
		this.outtime=outtime;
		this.destination=destination;
		this.loadform=loadform;
		this.transcode=transcode;
		this.motorcode=motorcode;
		this.id=id;
		
		
	}
	
	
	
	public ResultMessage passform(){
		StockoutPO newpo=new StockoutPO(id,ordercode, outtime,destination, loadform, transcode, motorcode);
		CommodityPO compo;//由数据层查得的commodityPO
		
		//compo.outtime=//得到当前时间；
		
		
		
		
		ResultMessage result=ResultMessage.success;
		return result;
	}

}
