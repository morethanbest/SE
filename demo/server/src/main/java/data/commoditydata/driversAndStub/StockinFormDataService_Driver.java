//package data.commoditydata.driversAndStub;
//
//import java.rmi.RemoteException;
//import java.util.List;
//
//import po.City;
//import po.CommodityLocation;
//import po.Formstate;
//import po.StockinPO;
//import dataservice.commoditydataservice.StockinFormDataService;
//
//
//
//public class StockinFormDataService_Driver {
//	public void drive(StockinFormDataService stockinFormDataService) throws RemoteException{
//		stockinFormDataService.addStockinForm(new StockinPO(012276, "1204304632", 20130528, new CommodityLocation(120, 45, 77, 15),City.Guangzhou));
//		List<StockinPO> list1 = stockinFormDataService.getStockinForm(Formstate.waiting);
//		System.out.println("Got it!");
//		System.out.println("It has " + list1.size() + " StockinForm");
//		stockinFormDataService.updateStockinForm(new StockinPO(012276, "1204304632", 20130528, new CommodityLocation(120, 45, 77, 15),City.Guangzhou));
//	}
//	public static void main(String[] args) throws RemoteException {
//		StockinFormDataService stockinFormDataService = new StockinFormDataService_Stub();
//		StockinFormDataService_Driver driver = new StockinFormDataService_Driver();
//		driver.drive(stockinFormDataService);
//	}
//}
