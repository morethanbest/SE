package data.logisticsdata;

import java.rmi.RemoteException;
import java.util.List;

import po.Arrivalstate;
import po.Formstate;
import po.GoodsReceivingPO;
import po.Hall;
import dataservice.logisticsdataservice.GoodsReceivingFormDataService;

public class GoodsReceivingFormDataService_Driver {
	public void drive(GoodsReceivingFormDataService goodsReceivingFormDataController) {
		GoodsReceivingPO po=new GoodsReceivingPO(425220, 20140521, "0251201411200000002", Hall.Nanjing, Arrivalstate.intact);
		try {
			goodsReceivingFormDataController.addGoodsReceivingForm(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("Add Failure!");
		}
		try {
			goodsReceivingFormDataController.updateGoodsReceivingForm(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("Update Failure!");
		}
		try {
			List<GoodsReceivingPO> list=goodsReceivingFormDataController.getGoodsReceivingForm(Formstate.waiting);
			if(list==null)
				System.out.println("No List Exists!");
			else
				System.out.println("Get List Succeed!");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("Get List Failure!");
		}
		
	}
	public static void main(String[] args) {
		GoodsReceivingFormDataService goodsReceivingFormDataController=new GoodsReceivingFormDataService_Stub();
		GoodsReceivingFormDataService_Driver driver= new GoodsReceivingFormDataService_Driver();
		driver.drive(goodsReceivingFormDataController);
	}

}
