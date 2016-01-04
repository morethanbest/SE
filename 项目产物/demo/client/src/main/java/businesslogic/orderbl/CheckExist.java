package businesslogic.orderbl;

import java.rmi.RemoteException;

import businesslogicservice.orderblservice.CheckExistBlService;
import dataservice.orderdataservice.OrderFormDataService;
import init.RMIHelper;
import po.ResultMessage;

public class CheckExist implements CheckExistBlService{

	@Override
	public boolean checkExist(String ordercode) {
		// TODO Auto-generated method stub
		try{
		OrderFormDataService orderFormDataService=RMIHelper.getOrderformdata();
		if(orderFormDataService.getOrderForm(ordercode)==null)
			return false;
		else
			return true;	
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
}
