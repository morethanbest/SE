package Bldriver;

import java.rmi.RemoteException;

import po.Ordertype;
import vo.LogisticsVO;
import vo.OrderVO;
import businesslogic.logisticsbl.stub.GetOrderbyONBlService_Stub;
import businesslogicservice.logisticsblservice.SearchOrderBlService;

public class Logistics_Driver {
    public void drive(SearchOrderBlService getOrderbyON) throws RemoteException{
    	LogisticsVO vo=getOrderbyON.getOrderbyOrderNumber("1");
    	if(vo!=null){
    		System.out.println("Search succeeds");
    	}
    	else{
    		System.out.println("Search fails");
    	}
    }
	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		SearchOrderBlService getOrderbyON=new GetOrderbyONBlService_Stub();
		Logistics_Driver driver=new Logistics_Driver();
		driver.drive(getOrderbyON);
	}

}
