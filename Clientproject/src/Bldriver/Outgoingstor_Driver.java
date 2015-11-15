package Bldriver;

import java.rmi.RemoteException;

import vo.ResultMessage;
import vo.StockoutVO;
import businesslogic.commoditybl.blstub.StockoutBlService_Stub;
//import businesslogic.commoditybl.StockoutBlService_Stub;
import businesslogicservice.commodityblservice.StockoutBlService;


public class Outgoingstor_Driver {
    public void drive(StockoutBlService stockoutBlService) throws RemoteException{
    	StockoutVO vo=new StockoutVO(null, 0, null, null, null, null);
    	ResultMessage result=stockoutBlService.Stockout(vo);
    	if(result==ResultMessage.success){
    		System.out.println("Stockout succeeds");
    	}
    	else{
    		System.out.println("Stockout fails");
    	}
    }
	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		StockoutBlService stockoutBlService=new StockoutBlService_Stub();
		Outgoingstor_Driver driver=new Outgoingstor_Driver();
		driver.drive(stockoutBlService);
	}

}