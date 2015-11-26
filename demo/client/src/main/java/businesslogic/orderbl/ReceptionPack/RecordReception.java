package businesslogic.orderbl.ReceptionPack;

import dataservice.orderdataservice.OrderFormDataService;
import init.RMIHelper;
import po.Formstate;
import po.OrderPO;
import po.ResultMessage;

public class RecordReception {
	String ordercode;
	String receiver;
	long receivingtime;
	public void setRecordInfo(String ordercode, String receiver, long receivingtime){
		this.ordercode=ordercode;
		this.receiver=receiver;
		this.receivingtime=receivingtime;
	}
	public ResultMessage Record(){
		OrderFormDataService order=RMIHelper.getOrderformdata();
		OrderPO po;
		ResultMessage result;
		try {
			po=order.getOrderForm(ordercode);
			po.setReceiver(receiver);
			po.setReceivingtime(receivingtime);
			po.setFormstate(Formstate.waiting);
		    result=ResultMessage.success;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result=ResultMessage.failure;
			System.out.println("Reception fail");
		}
		return result;
	}

}
