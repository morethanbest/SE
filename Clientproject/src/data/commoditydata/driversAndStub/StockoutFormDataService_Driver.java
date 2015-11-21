//package data.commoditydata.driversAndStub;
//
//import java.rmi.RemoteException;
//import java.util.List;
//
//import po.Formstate;
//import po.Hall;
//import po.Loadform;
//import po.StockoutPO;
//import dataservice.commoditydataservice.StockoutFormDataService;
//
//public class StockoutFormDataService_Driver {
//	public void drive(StockoutFormDataService stockoutFormDataService) throws RemoteException{
//		stockoutFormDataService.addStockoutForm(new StockoutPO(4520556,"1036565287", 20140517, Hall.Nanjing1, Loadform.truck, "0251201411200000002", "0251201304120000001"));
//		stockoutFormDataService.updateStockoutForm(new StockoutPO(4520556,"1036565287", 20140517, Hall.Nanjing1, Loadform.truck, "0251201411200000002", "0251201304120000001"));
//		List<StockoutPO> list = stockoutFormDataService.getStockoutForm(Formstate.waiting);
//		System.out.println("Got it!");
//		System.out.println("It has " + list.size() + " StockoutForm");
//	}
//	public static void main(String[] args) throws RemoteException {
//		StockoutFormDataService stockoutFormDataService = new StockoutFormDataService_Stub();
//		StockoutFormDataService_Driver driver = new StockoutFormDataService_Driver();
//		driver.drive(stockoutFormDataService);
//	}
//}
