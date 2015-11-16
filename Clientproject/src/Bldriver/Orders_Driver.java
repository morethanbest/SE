package Bldriver;

import java.rmi.RemoteException;

import po.Ordertype;
import vo.OrderFareVO;
import vo.OrderVO;
import vo.ReceptionVO;
import vo.ResultMessage;
import businesslogic.orderbl.OrderBlService_Stub;
import businesslogicservice.orderblservice.OrderBlService;

public class Orders_Driver {
	 public void drive(OrderBlService orderBlService) throws RemoteException{
		    OrderVO vo=new OrderVO("1","1","1","1","1","1","1","1","1","1",1,1,1,"1",1,1,"1",Ordertype.economical);
	    	ResultMessage result=orderBlService.addOrder(vo);
	    	if(result==ResultMessage.success){
	    		System.out.println("order succeeds");
	    	}
	    	else{
	    		System.out.println("order fails");
	    	}
	    	OrderFareVO vo1=new OrderFareVO(null, null, 0, 0, 0, 0, 0, null);
	    	double result1=orderBlService.orderFare(vo1);
	    	if(result1==0){
	    		System.out.println("orderfare succeeds");
	    	}
	    	else{
	    		System.out.println("orderfare fails");
	    	}
	    	ReceptionVO vo2=new ReceptionVO(null, null, 0);
//	    	ResultMessage result2=orderBlService.reception(vo2);
	    	if(result==ResultMessage.success){
	    		System.out.println("reception succeeds");
	    	}
	    	else{
	    		System.out.println("reception fails");
	    	}
	    }
		public static void main(String[] args) throws RemoteException {
			// TODO Auto-generated method stub
			OrderBlService orderBlService=new OrderBlService_Stub();
			Orders_Driver driver=new Orders_Driver();
			driver.drive(orderBlService);
		}


}
