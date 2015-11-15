package Bldriver;

import java.rmi.RemoteException;

import vo.GoodsReceivingVO;
import vo.ResultMessage;
import businesslogic.logisticsbl.stub.GoodsRecevingBlService_Stub;
import businesslogicservice.logisticsblservice.GoodsRecevingBlService;
import businesslogicservice.orderblservice.OrderBlService;

public class GoodsReceving_Driver {
	public void drive(GoodsRecevingBlService goodsRecevingBlService) throws RemoteException{
		GoodsReceivingVO vo=new GoodsReceivingVO(0, null, null, null);
		ResultMessage result=goodsRecevingBlService.GoodsReceving(vo);
		if(result==ResultMessage.success){
    		System.out.println("GoodsReceving succeeds");
    	}
    	else{
    		System.out.println("GoodsReceving fails");
    	}
	}
	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		GoodsRecevingBlService goodsRecevingBlService=new GoodsRecevingBlService_Stub();
		GoodsReceving_Driver driver=new GoodsReceving_Driver();
		driver.drive(goodsRecevingBlService);
	}
}
