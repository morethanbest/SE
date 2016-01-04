package data.datafactory;

import data.accountdata.AccountData;
import data.accountdata.NewBookData;
import data.balancedata.DebitnoteFormData;
import data.balancedata.RecordcollectFormData;
import data.balancedata.RecordpayFormData;
import data.commoditydata.CommodityData;
import data.commoditydata.StockinFormData;
import data.commoditydata.StockoutFormData;
import data.logisticsdata.*;
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
import dataservice.accountdataservice.AccountDataService;
import dataservice.accountdataservice.NewBookDataService;
import dataservice.balancedataservice.DebitnoteFormDataService;
import dataservice.balancedataservice.RecordcollectFormDataService;
import dataservice.balancedataservice.RecordpayFormDataService;
import dataservice.commoditydataservice.CommodityDataService;
import dataservice.commoditydataservice.StockinFormDataService;
import dataservice.commoditydataservice.StockoutFormDataService;
import dataservice.datafactoryservice.datafactoryserv;
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

import java.rmi.RemoteException;


public  class databaseFactory extends datafactoryserv{

	@Override
	public AccountDataService getAccount() throws RemoteException{
		// TODO Auto-generated method stub
		return new AccountData();
	}

	@Override
	public NewBookDataService getNewbook() throws  RemoteException{
		// TODO Auto-generated method stub
		return  new NewBookData();
	}

	@Override
	public DebitnoteFormDataService getDebitnote() throws  RemoteException{
		// TODO Auto-generated method stub
		return  new DebitnoteFormData();
	}

	@Override
	public RecordcollectFormDataService getRecordcollect() throws RemoteException{
		// TODO Auto-generated method stub
		return new RecordcollectFormData();
	}

	@Override
	public RecordpayFormDataService getRecordpay() throws RemoteException{
		// TODO Auto-generated method stub
		return new RecordpayFormData();
	}

	@Override
	public CommodityDataService getCommodity() throws RemoteException{
		// TODO Auto-generated method stub
		return new CommodityData();
	}

	@Override
	public StockinFormDataService getStockin() throws  RemoteException{
		// TODO Auto-generated method stub
		return new StockinFormData();
	}

	@Override
	public StockoutFormDataService getStockout() throws RemoteException{
		// TODO Auto-generated method stub
		return new StockoutFormData();
	}

	@Override
	public ArrivalFormDataService getArrivalform() throws  RemoteException{
		// TODO Auto-generated method stub
		return new ArrivalFormData();
	}

	@Override
	public CenterLoadFormDataService getCenterload() throws RemoteException{
		// TODO Auto-generated method stub
		return new CenterLoadFormData();
	}

	@Override
	public DeliveryFormDataService getDelivery() throws  RemoteException{
		// TODO Auto-generated method stub
		return new DeliveryFormData();
	}

	@Override
	public GoodsReceivingFormDataService getGoodsreceving() throws  RemoteException{
		// TODO Auto-generated method stub
		return new GoodsReceivingFormData();
	}

	@Override
	public HallLoadFormDataService getHallload() throws  RemoteException{
		// TODO Auto-generated method stub
		return new HallLoadFormData();
	}

	@Override
	public LogisticsInfoService getLogisticsinfo() throws  RemoteException{
		// TODO Auto-generated method stub
		return new LogisticsInfo();
	}

	@Override
	public RecordtransFormDataService getRecordtrans() throws  RemoteException{
		// TODO Auto-generated method stub
		return new RecordtransFormData();
	}

	@Override
	public ConstantsDataService getConstants() throws  RemoteException{
		// TODO Auto-generated method stub
		return new ConstantsData();
	}

	@Override
	public OrganizationDataService getOrganization() throws  RemoteException{
		// TODO Auto-generated method stub
		return new OrganizationData();
	}

	@Override
	public SalaryDataService getSalary() throws  RemoteException{
		// TODO Auto-generated method stub
		return new SalaryData();
	}

	@Override
	public StaffDataService getStaff() throws  RemoteException{
		// TODO Auto-generated method stub
		return new StaffData();
	}

	@Override
	public LogisticsDataService getLogistics() throws  RemoteException{
		// TODO Auto-generated method stub
		return new LogisticsData();
	}

	@Override
	public OrderFormDataService getOrderform() throws  RemoteException{
		// TODO Auto-generated method stub
		return new OrderFormData();
	}

	@Override
	public DriversDataService getDrivers() throws  RemoteException{
		// TODO Auto-generated method stub
		return new DriversData();
	}

	@Override
	public VehicleDataService getVehicles() throws  RemoteException{
		// TODO Auto-generated method stub
		return new VehicleData();
	}

	@Override
	public UserDataService getUser() throws  RemoteException{
		// TODO Auto-generated method stub
		return new UsersData();
	}

	@Override
	public UserLoginDataService getUserlogin() throws  RemoteException{
		// TODO Auto-generated method stub
		return new UserLoginData();
	}
	

}
