package Bldriver;

import java.rmi.RemoteException;

import businesslogic.logisticsbl.stub.CenterloadBlService_Stub;
import businesslogicservice.logisticsblservice.CenterloadBlService;
import vo.CenterloadVO;
import vo.ResultMessage;


public class Centerload_Driver {
    public void drive(CenterloadBlService centerloadBlService) throws RemoteException{
    	CenterloadVO vo=new CenterloadVO(0, null, null, null, null, null, null);
    	ResultMessage result=centerloadBlService.addCenterLoadForm(vo);
    	if(result==ResultMessage.success){
    		System.out.println("Centerload succeeds");
    	}
    	else{
    		System.out.println("Centerload fails");
    	}
    }
	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		CenterloadBlService centerloadBlService=new CenterloadBlService_Stub();
		Centerload_Driver driver=new Centerload_Driver();
		driver.drive(centerloadBlService);
	}

}