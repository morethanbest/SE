package Bldriver;

import java.rmi.RemoteException;

import vo.DeliveryVO;
import vo.ResultMessage;
import businesslogic.logisticsbl.DeliveryBlService_Stub;
import businesslogicservice.logisticsblservice.DeliveryBlService;


public class Delivery_Driver {
	public void drive(DeliveryBlService deliveryBlService) throws RemoteException{
		DeliveryVO vo=new DeliveryVO(0, null, null);
		ResultMessage result=deliveryBlService.Delivery(vo);
		if(result==ResultMessage.success){
    		System.out.println("Delivery succeeds");
    	}
    	else{
    		System.out.println("Delivery fails");
    	}
	}
	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		DeliveryBlService deliveryBlService=new DeliveryBlService_Stub();
		Delivery_Driver driver=new Delivery_Driver();
		driver.drive(deliveryBlService);
	}

}
