package Bldriver;

import java.rmi.RemoteException;

import businesslogic.accountbl.stub.AccountblService_Stub;
import businesslogicservice.accountblservice.AccountBlService;
import vo.AccountVO;
import vo.ResultMessage;

public class Account_Driver {
    public void drive(AccountBlService accountBlService) throws RemoteException{
    	AccountVO vo=new AccountVO(0, null, 0);
    	ResultMessage result =accountBlService.addAccount(vo);
    	if(result==ResultMessage.success){
    		System.out.println("addAccount succeeds");
    	}
    	else{
    		System.out.println("addAccount fails");
    	}
    	
    	ResultMessage result1 =accountBlService.delAccount();
    	if(result1==ResultMessage.success){
    		System.out.println("delAccount succeeds");
    	}
    	else{
    		System.out.println("delAccount fails");
    	}
    	
    	ResultMessage result2 =accountBlService.revAccount(vo);
    	if(result2==ResultMessage.success){
    		System.out.println("revAccount succeeds");
    	}
    	else{
    		System.out.println("revAccount fails");
    	}
    	
    	AccountVO vo1=accountBlService.getAccountbyID(0);
    	if(vo1!=null){
    		System.out.println("getAccountbyID succeeds");
    	}
    	else{
    		System.out.println("getAccountbyID fails");
    	}
    	
  
    }
	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		AccountBlService accountBlService=new AccountblService_Stub();
		Account_Driver driver=new Account_Driver();
		driver.drive(accountBlService);
	}

}
