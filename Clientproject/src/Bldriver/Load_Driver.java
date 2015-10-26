package Bldriver;

import java.rmi.RemoteException;

import vo.HallLoadVO;
import vo.ResultMessage;
import businesslogic.logisticsbl.HallLoadBlService_Stub;
import businesslogicservice.logisticsblservice.HallLoadBlService;

public class Load_Driver {
    public void drive(HallLoadBlService hallLoadBlService) throws RemoteException{
    	HallLoadVO vo=new HallLoadVO(0, null, null, null, null, null, null, null);
    	ResultMessage result=hallLoadBlService.addHallLoadForm(vo);
    	if(result==ResultMessage.success){
    		System.out.println("HallLoad succeeds");
    	}
    	else{
    		System.out.println("HallLoad fails");
    	}
    }
	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		HallLoadBlService hallLoadBlService=new HallLoadBlService_Stub();
		Load_Driver driver=new Load_Driver();
		driver.drive(hallLoadBlService);
	}

}
