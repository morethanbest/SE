package Bldriver;

import java.rmi.RemoteException;

import businesslogic.managerbl.ConstantsBlService_Stub;
import businesslogicservice.managerblservice.ConstantsBlService;
import vo.ConstantsVO;
import vo.ResultMessage;

public class Constants_Driver {
	public void driver(ConstantsBlService constantsBlservice){
		try{
			ResultMessage result=constantsBlservice.addConstants(new ConstantsVO("a",1));
			if(result==ResultMessage.success)
				System.out.println("Constants added");
			result=constantsBlservice.delConstants(new ConstantsVO("a",1));
			if(result==ResultMessage.success)
				System.out.println("Constants deleted");
			result=constantsBlservice.revConstants(new ConstantsVO("a",1));
			if(result==ResultMessage.success)
				System.out.println("rev successfully");
		}catch(RemoteException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		ConstantsBlService constantsbl=new ConstantsBlService_Stub();
		Constants_Driver driver=new Constants_Driver();
		driver.driver(constantsbl);
	}
}
