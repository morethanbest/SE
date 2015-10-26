package Bldriver;

import java.rmi.RemoteException;

import vo.StockExaminationVO;
import businesslogic.commoditybl.StockExaminationBlservice_Stub;
import businesslogicservice.commodityblservice.StockExaminationBlService;


public class StockExamination_Driver {
    public void drive(StockExaminationBlService stockExaminationBlService) throws RemoteException{
    	StockExaminationVO vo=stockExaminationBlService.StockExamination(0, 0);
    	if(vo!=null){
    		System.out.println("StockExamination succeeds");
    	}
    	else{
    		System.out.println("StockExamination fails");
    	}
    }
	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		StockExaminationBlService stockExaminationBlService=new StockExaminationBlservice_Stub();
		StockExamination_Driver driver=new StockExamination_Driver();
		driver.drive(stockExaminationBlService);
	}

}
