package Bldriver;

import java.rmi.RemoteException;

import vo.ResultMessage;
import vo.StockinVO;
import businesslogic.commoditybl.blstub.InboundBlService_Stub;
//import businesslogic.commoditybl.InboundBlService_Stub;
import businesslogicservice.commodityblservice.InboundBlService;


public class Inbound_Driver {
    public void drive(InboundBlService inboundBlService) throws RemoteException{
    	StockinVO vo=new StockinVO(null, 0, null, null);
    	ResultMessage result=inboundBlService.Inbound(vo);
    	if(result==ResultMessage.success){
    		System.out.println("Inbound succeeds");
    	}
    	else{
    		System.out.println("Inbound fails");
    	}
    }
	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		InboundBlService inboundBlService=new InboundBlService_Stub();
		Inbound_Driver driver=new Inbound_Driver();
		driver.drive(inboundBlService);
	}

}

