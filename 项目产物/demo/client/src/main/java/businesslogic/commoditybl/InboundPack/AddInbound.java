package businesslogic.commoditybl.InboundPack;

import dataservice.commoditydataservice.CommodityDataService;
import dataservice.commoditydataservice.StockinFormDataService;
import init.RMIHelper;
import po.*;


import java.rmi.RemoteException;

public class AddInbound {



	String id;
	String ordercode;
	long intime;
	CommodityLocation location;
	String destination;
	Formstate formstate;

	public void set(String id,String ordercode, long intime, CommodityLocation location,
					 String destination,Formstate formstate) {

		this.id=id;
		this.ordercode = ordercode;
		this.intime = intime;
		this.location = location;
		this.destination = destination;
		this.formstate=formstate;
	}
	
	
	
	public ResultMessage passform(){
		StockinPO newpo=new StockinPO(id,ordercode,intime,location,destination,formstate);

		StockinFormDataService data= RMIHelper.getStockinform();
		ResultMessage result=null;
		try {
			result=data.addStockinForm(newpo);
		} catch (RemoteException e) {
			System.out.println("Add stockin form failed!!!");
			e.printStackTrace();
		}


		return result;
				
		
		
	}
	

}
