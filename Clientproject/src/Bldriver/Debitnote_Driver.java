package Bldriver;

import java.rmi.RemoteException;

import businesslogic.balancebl.DebitnoteBlService_Stub;
import businesslogicservice.balanceblservice.DebitnoteBlService;
import vo.DebitnoteVO;
import vo.ResultMessage;


public class Debitnote_Driver {
    public void drive(DebitnoteBlService debitnoteBlService) throws RemoteException{
    	DebitnoteVO vo=new DebitnoteVO(0, null, null, null, 0, null);
    	ResultMessage result=debitnoteBlService.Debitnote(vo);
    	if(result==ResultMessage.success){
    		System.out.println("Debitnote succeeds");
    	}
    	else{
    		System.out.println("Debitnote fails");
    	}
    }
	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		DebitnoteBlService debitnoteBlService=new DebitnoteBlService_Stub();
		Debitnote_Driver driver=new Debitnote_Driver();
		driver.drive(debitnoteBlService);
	}

}
