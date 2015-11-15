package Bldriver;

import java.rmi.RemoteException;

import businesslogic.logisticsbl.ArrivalBlService_Stub;
import businesslogicservice.logisticsblservice.ArrivalBlService;
import vo.ArrivalVO;
import vo.ResultMessage;


public class Arrival_Driver {
    public void drive(ArrivalBlService arrivalBlService) throws RemoteException{
    	ArrivalVO vo=new ArrivalVO(null, 0, null, null, null);
    	ResultMessage result=arrivalBlService.addArrival(vo);
    	if(result==ResultMessage.success){
    		System.out.println("Arrival succeeds");
    	}
    	else{
    		System.out.println("Arrival fails");
    	}
    }
	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		ArrivalBlService arrivalBlService=new ArrivalBlService_Stub();
		Arrival_Driver driver=new Arrival_Driver();
		driver.drive(arrivalBlService);
	}

}
