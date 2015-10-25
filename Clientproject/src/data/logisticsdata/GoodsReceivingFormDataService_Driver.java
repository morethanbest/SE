package data.logisticsdata;

import java.rmi.RemoteException;
import java.util.List;

import po.Arrivalstate;
import po.Formstate;
import po.GoodsReceivingPO;
import po.Hall;
import dataservice.logisticsdataservice.GoodsReceivingFormDataService;

public class GoodsReceivingFormDataService_Driver {
	public void drive(GoodsReceivingFormDataService goodsReceivingFormDataController) throws RemoteException{
		GoodsReceivingPO po=new GoodsReceivingPO(425220, 20140521, "0251201411200000002", Hall.Nanjing, Arrivalstate.intact);
		goodsReceivingFormDataController.addGoodsReceivingForm(po);
		goodsReceivingFormDataController.updateGoodsReceivingForm(po);
		List<GoodsReceivingPO> list=goodsReceivingFormDataController.getGoodsReceivingForm(Formstate.waiting);
		
	}
	public static void main(String[] args) throws RemoteException {
		GoodsReceivingFormDataService goodsReceivingFormDataController=new GoodsReceivingFormDataService_Stub();
		GoodsReceivingFormDataService_Driver driver= new GoodsReceivingFormDataService_Driver();
		driver.drive(goodsReceivingFormDataController);
	}

}
