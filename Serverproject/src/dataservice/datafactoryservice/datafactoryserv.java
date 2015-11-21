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

public abstract class datafactoryserv {
	
	//account
		AccountDataService account;
		NewBookDataService newbook;
		//balance
		DebitnoteFormDataService debitnote;
		RecordcollectFormDataService recordcollect;
		RecordpayFormDataService recordpay;
		//commodity
		CommodityDataService commodity;
		StockinFormDataService stockin;
		StockoutFormDataService stockout;
		//logistics
		ArrivalFormDataService arrivalform;
		CenterLoadFormDataService centerload;
		DeliveryFormDataService delivery;
		GoodsReceivingFormDataService goodsreceving;
		HallLoadFormDataService hallload;
		LogisticsInfoService logisticsinfo;
		RecordtransFormDataService recordtrans;
		//manager
		ConstantsDataService constants;
		OrganizationDataService organization;
		SalaryDataService salary;
		StaffDataService staff;
		//order
		LogisticsDataService logistics;
		OrderFormDataService orderform;
		//transport
		DriversDataService drivers;
		VehicleDataService vehicles;
		//user
		UserDataService user;
		UserLoginDataService userlogin;
		
		
	

}
