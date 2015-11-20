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
			AccountData  account=new AccountData();
			NewBookData newbook=new NewBookData();
			//balance
			DebitnoteFormData debitnote=new DebitnoteFormData();
			RecordcollectFormData recordcollect=new RecordcollectFormData();
			RecordpayFormData recordpay=new RecordpayFormData();
			//commodity
			CommodityData commodity=new CommodityData();
			StockinFormData stockin=new StockinFormData();
			StockoutFormData stockout=new StockoutFormData();
			//logistics
			ArrivalFormData arrivalform=new ArrivalFormData();
			CenterLoadFormData centerload=new CenterLoadFormData();
			DeliveryFormData delivery=new DeliveryFormData();
			GoodsReceivingFormData goodsreceving=new GoodsReceivingFormData();
			HallLoadFormData hallload=new HallLoadFormData();
			LogisticsInfo logisticsinfo=new LogisticsInfo();
			RecordtransFormData recordtrans=new RecordtransFormData();
			//manager
			ConstantsData constants=new ConstantsData();
			OrganizationData organization=new OrganizationData();
			SalaryData salary=new SalaryData();
			StaffData staff=new StaffData();
			//order
			LogisticsData logistics=new LogisticsData();
			OrderFormData orderform=new OrderFormData();
			//transport
			DriversData drivers=new DriversData();
			VehicleData vehicles=new VehicleData();
			//user
			private UsersData user=new UsersData();
			private UserLoginData userlogin=new UserLoginData();
			
			public UsersData getUsersData(){
				return this.user;
			}
	
			public UserLoginData getUserLogin(){
				return this.userlogin;
			}
	

}
