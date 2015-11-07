package Bldriver;

import java.rmi.RemoteException;

import businesslogic.transportbl.DriverBlService_Stub;
import businesslogicservice.transportblservice.DriverBlService;
import vo.DriverVO;
import vo.ResultMessage;

public class Drivers_Driver {
    public void drive(DriverBlService DriverBlService) throws RemoteException{
    	DriverVO vo=new DriverVO(null, null, 0, null, null, null, 0);
    	ResultMessage result =DriverBlService.addDriver(vo);
    	if(result==ResultMessage.success){
    		System.out.println("addDriver succeeds");
    	}
    	else{
    		System.out.println("addDriver fails");
    	}
    	
    	ResultMessage result1 =DriverBlService.delDriver(vo);
    	if(result1==ResultMessage.success){
    		System.out.println("delDriver succeeds");
    	}
    	else{
    		System.out.println("delDriver fails");
    	}
    	
    	ResultMessage result2 =DriverBlService.revDriver(vo);
    	if(result2==ResultMessage.success){
    		System.out.println("revDriver succeeds");
    	}
    	else{
    		System.out.println("revDriver fails");
    	}
    	
    	DriverVO vo1=DriverBlService.getDriverbyDN("1");
    	if(vo1!=null){
    		System.out.println("getDriverbyVN succeeds");
    	}
    	else{
    		System.out.println("getDriverbyVN fails");
    	}
    	
    	DriverVO vo2=DriverBlService.getDriverbyName("a");
    	if(vo2!=null){
    		System.out.println("getDriverbyName succeeds");
    	}
    	else{
    		System.out.println("getDriverbyName fails");
    	}
    }
	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		DriverBlService DriverBlService=new DriverBlService_Stub();
		Drivers_Driver driver=new Drivers_Driver();
		driver.drive(DriverBlService);
	}

}