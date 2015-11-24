package businesslogic.orderbl.OrderPack;

import dataservice.orderdataservice.OrderFormDataService;
import init.RMIHelper;

public class IdInfo {
	public long getId(){
		OrderFormDataService order=RMIHelper.getOrderformdata();
		long id;
		try {
			id=order.findLastID()+1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
		    id=0;
			System.out.println("getId fail");
		}
		return id;
	}

}
