package data.datafactory;

import data.accountdata.AccountData;
import data.accountdata.NewBookData;
import data.balancedata.DebitnoteFormData;
import data.balancedata.RecordcollectFormData;
import data.balancedata.RecordpayFormData;
import data.commoditydata.CommodityData;
import data.commoditydata.StockinFormData;
import data.commoditydata.StockoutFormData;
import data.logisticsdata.ArrivalFormData;
import data.logisticsdata.CenterLoadFormData;
import data.logisticsdata.DeliveryFormData;
import data.logisticsdata.GoodsReceivingFormData;
import data.logisticsdata.HallLoadFormData;
import data.logisticsdata.LogisticsInfo;
import data.logisticsdata.RecordtransFormData;
import data.managerdata.ConstantsData;
import data.managerdata.OrganizationData;
import data.managerdata.SalaryData;
import data.managerdata.StaffData;
import data.orderdata.LogisticsData;
import data.orderdata.OrderFormData;
import data.transportdata.DriversData;
import data.transportdata.VehicleData;
import data.userdata.UserLoginData;
import data.userdata.UsersData;
import dataservice.datafactoryservice.datafactoryserv;



public  class databaseFactory extends datafactoryserv{
	//account
			AccountData  account;
			NewBookData newbook;
			//balance
			DebitnoteFormData debitnote;
			RecordcollectFormData recordcollect;
			RecordpayFormData recordpay;
			//commodity
			CommodityData commodity;
			StockinFormData stockin;
			StockoutFormData stockout;
			//logistics
			ArrivalFormData arrivalform;
			CenterLoadFormData centerload;
			DeliveryFormData delivery;
			GoodsReceivingFormData goodsreceving;
			HallLoadFormData hallload;
			LogisticsInfo logisticsinfo;
			RecordtransFormData recordtrans;
			//manager
			ConstantsData constants;
			OrganizationData organization;
			SalaryData salary;
			StaffData staff;
			//order
			LogisticsData logistics;
			OrderFormData orderform;
			//transport
			DriversData drivers;
			VehicleData vehicles;
			//user
			private UsersData user;
			private UserLoginData userlogin;
			
			public UsersData getUsersData(){
				return this.user;
			}
	
			public UserLoginData getUserLogin(){
				return this.userlogin;
			}
	

}
