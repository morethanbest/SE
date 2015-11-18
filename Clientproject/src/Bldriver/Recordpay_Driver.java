package Bldriver;

import java.rmi.RemoteException;

import businesslogic.balancebl.RecordpayBlService_Stub;
import businesslogicservice.balanceblservice.RecordpayBlService;
import vo.RecordpayVO;
import vo.ResultMessage;

public class Recordpay_Driver {
	public void driver(RecordpayBlService recordpayBlservice){
	/*	try{
			ResultMessage result=recordpayBlservice.Recordpay(new RecordpayVO(1,1,"a",1,1,1,1,1,"a"));
			if(result==ResultMessage.success)
				System.out.println("recordpay added");
		}catch(RemoteException e){
			e.printStackTrace();
		}*/
	}
	public static void main(String[] args){
		RecordpayBlService recordpayBlservice=new RecordpayBlService_Stub();
		Recordpay_Driver driver=new Recordpay_Driver();
		driver.driver(recordpayBlservice);
	}
}
