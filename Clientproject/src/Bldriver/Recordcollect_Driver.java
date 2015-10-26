package Bldriver;

import java.rmi.RemoteException;

import vo.RecordcollectVO;
import vo.ResultMessage;
import businesslogic.balancebl.RecordCollectBlService_Stub;
import businesslogicservice.balanceblservice.RecordCollectBlService;

public class Recordcollect_Driver {
	public void drive(RecordCollectBlService recordCollectBlService) throws RemoteException{
		RecordcollectVO vo=new RecordcollectVO(0, 0, null, null);
		ResultMessage result=recordCollectBlService.Recordcollect(vo);
		if(result==ResultMessage.success){
    		System.out.println("recordCollect succeeds");
    	}
    	else{
    		System.out.println("recordCollect fails");
    	}
	}
	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		RecordCollectBlService recordCollectBlService=new RecordCollectBlService_Stub();
		Recordcollect_Driver driver=new Recordcollect_Driver();
		driver.drive(recordCollectBlService);
	}

}
