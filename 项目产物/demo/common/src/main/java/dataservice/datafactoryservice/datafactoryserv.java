package dataservice.datafactoryservice;

import dataservice.accountdataservice.AccountDataService;
import dataservice.accountdataservice.NewBookDataService;
import dataservice.balancedataservice.DebitnoteFormDataService;
import dataservice.balancedataservice.RecordcollectFormDataService;
import dataservice.balancedataservice.RecordpayFormDataService;
import dataservice.commoditydataservice.CommodityDataService;
import dataservice.commoditydataservice.StockinFormDataService;
import dataservice.commoditydataservice.StockoutFormDataService;
import dataservice.logisticsdataservice.ArrivalFormDataService;
import dataservice.logisticsdataservice.CenterLoadFormDataService;
import dataservice.logisticsdataservice.DeliveryFormDataService;
import dataservice.logisticsdataservice.GoodsReceivingFormDataService;
import dataservice.logisticsdataservice.HallLoadFormDataService;
import dataservice.logisticsdataservice.LogisticsInfoService;
import dataservice.logisticsdataservice.RecordtransFormDataService;
import dataservice.managerdataservice.ConstantsDataService;
import dataservice.managerdataservice.OrganizationDataService;
import dataservice.managerdataservice.SalaryDataService;
import dataservice.managerdataservice.StaffDataService;
import dataservice.orderdataservice.LogisticsDataService;
import dataservice.orderdataservice.OrderFormDataService;
import dataservice.transportdataservice.DriversDataService;
import dataservice.transportdataservice.VehicleDataService;
import dataservice.userdataservice.UserDataService;
import dataservice.userdataservice.UserLoginDataService;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract class datafactoryserv implements Remote {
	   //protected datafactoryserv(){}

	    
	//account
		public abstract AccountDataService getAccount() throws RemoteException;
		public abstract NewBookDataService getNewbook() throws RemoteException;
		//balance
		public abstract DebitnoteFormDataService getDebitnote() throws RemoteException;
		public abstract RecordcollectFormDataService getRecordcollect() throws RemoteException;
		public abstract RecordpayFormDataService getRecordpay() throws RemoteException;
		//commodity
		public abstract CommodityDataService getCommodity() throws RemoteException;
		public abstract StockinFormDataService getStockin() throws RemoteException;
		public abstract StockoutFormDataService getStockout() throws RemoteException;
		//logistics
		public abstract ArrivalFormDataService getArrivalform() throws RemoteException;
		public abstract CenterLoadFormDataService getCenterload() throws RemoteException;
		public abstract DeliveryFormDataService getDelivery() throws RemoteException;
		public abstract GoodsReceivingFormDataService getGoodsreceving() throws RemoteException;
		public abstract HallLoadFormDataService getHallload() throws RemoteException;
		public abstract LogisticsInfoService getLogisticsinfo() throws RemoteException;
		public abstract RecordtransFormDataService getRecordtrans() throws RemoteException;
		//manager
		public abstract ConstantsDataService getConstants() throws RemoteException;
		public abstract OrganizationDataService getOrganization() throws RemoteException;
		public abstract SalaryDataService getSalary() throws RemoteException;
		public abstract StaffDataService getStaff() throws RemoteException;
		//order
		public abstract LogisticsDataService getLogistics() throws RemoteException;
		public abstract OrderFormDataService getOrderform() throws RemoteException;
		//transport
		public abstract DriversDataService getDrivers() throws RemoteException;
		public abstract VehicleDataService getVehicles() throws RemoteException;
		//user
		public abstract UserDataService getUser() throws RemoteException;
		public abstract UserLoginDataService getUserlogin() throws RemoteException;
		
		
	

}
