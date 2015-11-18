package Bldriver;

import java.rmi.RemoteException;

import vo.RecordtransVO;
import vo.ResultMessage;
import businesslogic.logisticsbl.stub.RecordtranBlService_Stub;
import businesslogicservice.logisticsblservice.RecordtransBlService;

public class Recordtrans_Driver {
    public void drive(RecordtransBlService recordtranBlService) throws RemoteException{
    /*	RecordtransVO vo=new RecordtransVO(0, 0, null, null, null, null, 0, null, null);
    	ResultMessage result=recordtranBlService.Recordtrans(vo);
    	if(result==ResultMessage.success){
    		System.out.println("Recordtrans succeeds");
    	}
    	else{
    		System.out.println("Recordtrans fails");
    	}*/
    }
	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		RecordtransBlService recordtransBlService=new RecordtranBlService_Stub();
		Recordtrans_Driver driver=new Recordtrans_Driver();
		driver.drive(recordtransBlService);
	}

}
