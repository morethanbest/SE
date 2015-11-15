package Bldriver;

import java.rmi.RemoteException;


import businesslogic.commoditybl.blstub.SubregionBlService_Stub;
//import businesslogic.commoditybl.SubregionBlService_Stub;
import businesslogicservice.commodityblservice.SubregionBlService;
import vo.ResultMessage;

public class Subregion_Driver {
    public void drive(SubregionBlService subregionBlService) throws RemoteException{
    	ResultMessage result=subregionBlService.Subregion(null, null);
    	if(result==ResultMessage.success){
    		System.out.println("Subregion succeeds");
    	}
    	else{
    		System.out.println("Subregion fails");
    	}
    }
	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		SubregionBlService subregionBlService=new SubregionBlService_Stub();
		Subregion_Driver driver=new Subregion_Driver();
		driver.drive(subregionBlService);
	}

}