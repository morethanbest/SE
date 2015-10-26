package data.commoditydata;

import java.rmi.RemoteException;
import java.util.List;

import po.CommodityLocation;
import po.CommodityPO;
import dataservice.commoditydataservice.CommodityDataService;

public class CommodityDataService_Driver {
	public void drive(CommodityDataService commodityDataService) throws RemoteException{
		List<CommodityPO> list1 = commodityDataService.getallCommodity();
		System.out.println("Got it!");
		System.out.println("It has " + list1.size() + " Commodity");
		List<CommodityPO> list2 = commodityDataService.getCommodityBetween(20140101, 20150101);
		System.out.println("Got it!");
		System.out.println("It has " + list2.size() + " Commodity");
		commodityDataService.addnew(new CommodityPO(102335, "1201836287", 20120722, new CommodityLocation(15, 78, 22, 100),0 ));
		commodityDataService.changeLocation(new CommodityPO(102335, "1201836287", 20120722, new CommodityLocation(15, 78, 22, 100),0 ), new CommodityLocation(1, 78, 22, 100));
		commodityDataService.setOuttime(new CommodityPO(102335, "1201836287", 20120722, new CommodityLocation(15, 78, 22, 100),0 ), 20150101);
	}
	public static void main(String[] args) throws RemoteException {
		CommodityDataService commodityDataService = new CommodityDataService_Stub();
		CommodityDataService_Driver driver = new CommodityDataService_Driver();
		driver.drive(commodityDataService);
	}
}
