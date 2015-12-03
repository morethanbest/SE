package businesslogic.orderbl.OrderPack;

import dataservice.orderdataservice.OrderFormDataService;
import init.RMIHelper;

public class GetOrderCode {
	public String getCode(String orgcode){
		OrderFormDataService order=RMIHelper.getOrderformdata();
		String s;
		try {
			long id=order.findLastID(orgcode)+1;
			s=Long.toString(id);
			int k = s.length();
			for(int i=0;i<10-k;i++){
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
