package businesslogic.orderbl.OrderPack;

import data.orderdata.OrderFormData;
import dataservice.orderdataservice.OrderFormDataService;

public class GetOrderCode {
	public String getCode(){
		OrderFormDataService order=new OrderFormData();
		String s;
		try {
			long id=order.findLastID()+1;
			s=Long.toString(id);
			for(int i=0;i<10-s.length();i++){
				s="0"+s;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			s="0000000000";
			System.out.println("getCode fail");
		}
		return s;
	}
}
