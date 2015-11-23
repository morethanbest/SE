package businesslogic.orderbl.OrderPack;

import data.orderdata.OrderFormData;
import dataservice.orderdataservice.OrderFormDataService;

public class IdInfo {
	public long getId(){
		OrderFormDataService order=new OrderFormData();
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
