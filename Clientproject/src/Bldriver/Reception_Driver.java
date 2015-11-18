package Bldriver;

import java.rmi.RemoteException;

import vo.ReceptionVO;
import vo.ResultMessage;
import businesslogic.orderbl.OrderBlService_Stub;
import businesslogicservice.orderblservice.OrderBlService;

public class Reception_Driver {
	 public void drive(OrderBlService orderBlService) throws RemoteException{
		 ReceptionVO vo=new ReceptionVO(null, null, 0);
	    /*	ResultMessage result=orderBlService.reception(vo);
	    	if(result==ResultMessage.success){
	    		System.out.println("reception succeeds");
	    	}
	    	else{
	    		System.out.println("reception fails");
	    	}*/
	 }

	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		OrderBlService orderBlService=new OrderBlService_Stub();
		Reception_Driver driver=new Reception_Driver();
		driver.drive(orderBlService);
	}

}
