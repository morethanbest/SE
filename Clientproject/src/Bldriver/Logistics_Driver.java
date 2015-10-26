package Bldriver;

import java.rmi.RemoteException;

import po.Ordertype;
import vo.OrderVO;
import businesslogic.logisticsbl.GetOrderbyONBlService_Stub;
import businesslogicservice.logisticsblservice.GetOrderbyONBlService;

public class Logistics_Driver {
    public void drive(GetOrderbyONBlService getOrderbyON) throws RemoteException{
    	OrderVO vo=getOrderbyON.getOrderbyON("1");
    	if(vo!=null){
    		System.out.println("Search succeeds");
    	}
    	else{
    		System.out.println("Search fails");
    	}
    }
	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		GetOrderbyONBlService getOrderbyON=new GetOrderbyONBlService_Stub();
		Logistics_Driver driver=new Logistics_Driver();
		driver.drive(getOrderbyON);
	}

}
