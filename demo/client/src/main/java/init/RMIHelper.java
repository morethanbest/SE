package init;

/**
 * Created by Administrator on 2015/11/23.
 */

import dataservice.accountdataservice.AccountDataService;
import dataservice.accountdataservice.NewBookDataService;
import dataservice.balancedataservice.*;
import dataservice.commoditydataservice.CommodityDataService;
import dataservice.commoditydataservice.StockinFormDataService;
import dataservice.commoditydataservice.StockoutFormDataService;
import dataservice.logisticsdataservice.*;
import dataservice.managerdataservice.*;
import dataservice.orderdataservice.LogisticsDataService;
import dataservice.orderdataservice.OrderFormDataService;
import dataservice.transportdataservice.DriversDataService;
import dataservice.transportdataservice.VehicleDataService;
import dataservice.userdataservice.UserDataService;
import dataservice.userdataservice.UserLoginDataService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;







public class RMIHelper {

    private static final String IP = "114.212.43.239"; //Can be read from config file

    private static boolean inited = false;

    private static AccountDataService accountdata;
    private static NewBookDataService newbook;

    private static DebitnoteFormDataService debitnote;
    private static RecordcollectFormDataService recordcollect;
    private static RecordpayFormDataService recordpay;
    private static BalanceDataService balancedata;
    private static StatisticsDataService statistics;

    private static CommodityDataService commoditydata;
    private static StockinFormDataService stockinform;
    private static StockoutFormDataService stockouform;
    private static ArrivalFormDataService arrivalform;
    private static CenterLoadFormDataService centerloaddata;
    private static DeliveryFormDataService deliveryformdata;
    private static GoodsReceivingFormDataService goodsreceiving;
    private static HallLoadFormDataService hallloadform;
    private static LogisticsInfoService logisticsinfo;
    private static RecordtransFormDataService recordtrans;
    private static ConstantsDataService constantsdata;
    private static OrganizationDataService orgdata;
    private static SalaryDataService salarydata;
    private static StaffDataService staffdata;
    private static LogisticsDataService logisticsdata;
    private static OrderFormDataService orderformdata;
    private static DriversDataService driverdata;
    private static VehicleDataService vehicledata;
    private static UserDataService userdata;
    private static UserLoginDataService userlogindata;
    private static CityDataService citydata;


    public synchronized static void init() throws ClientInitException {
        if (inited) {
            return;
        }

        try {
            initObjects();
            inited = true;
        } catch (Exception e) {
            throw new ClientInitException(e);
        }
    }

    private static void initObjects() throws MalformedURLException, RemoteException, NotBoundException {
        String urlPrefix = "rmi://" + IP + "/";
        accountdata = (AccountDataService) Naming.lookup(urlPrefix + "accountdata");
        newbook= (NewBookDataService) Naming.lookup(urlPrefix + "newbookdata");

        debitnote = (DebitnoteFormDataService) Naming.lookup(urlPrefix + "debitnotedata");
        recordcollect = (RecordcollectFormDataService) Naming.lookup(urlPrefix + "recordcollectdata");
        recordpay = (RecordpayFormDataService) Naming.lookup(urlPrefix + "recordpaydata");
        balancedata =(BalanceDataService)Naming.lookup(urlPrefix + "balancedata");
        statistics=(StatisticsDataService)Naming.lookup(urlPrefix + "statistics");

        commoditydata = (CommodityDataService) Naming.lookup(urlPrefix + "commoditydata");
        stockinform = (StockinFormDataService) Naming.lookup(urlPrefix + "stockindata");
        stockouform = (StockoutFormDataService) Naming.lookup(urlPrefix + "stockoutdata");
        arrivalform = (ArrivalFormDataService) Naming.lookup(urlPrefix + "arrivaldata");
        centerloaddata = (CenterLoadFormDataService) Naming.lookup(urlPrefix + "centerloaddata");
        deliveryformdata = (DeliveryFormDataService) Naming.lookup(urlPrefix + "deliverydata");
        goodsreceiving = (GoodsReceivingFormDataService) Naming.lookup(urlPrefix + "goodsdata");
        hallloadform = (HallLoadFormDataService) Naming.lookup(urlPrefix + "hallloaddata");
        logisticsinfo = (LogisticsInfoService) Naming.lookup(urlPrefix + "logisticsinfodata");
        recordtrans = (RecordtransFormDataService) Naming.lookup(urlPrefix + "recordtransdata");
        constantsdata = (ConstantsDataService) Naming.lookup(urlPrefix + "constantsdata");
        orgdata = (OrganizationDataService) Naming.lookup(urlPrefix + "orgdata");
        salarydata = (SalaryDataService) Naming.lookup(urlPrefix + "salarydata");
        staffdata = (StaffDataService) Naming.lookup(urlPrefix + "staffdata");
        logisticsdata = (LogisticsDataService) Naming.lookup(urlPrefix + "logisticsdata");
        orderformdata = (OrderFormDataService) Naming.lookup(urlPrefix + "orderformdata");
        driverdata = (DriversDataService) Naming.lookup(urlPrefix + "driverdata");
        vehicledata = (VehicleDataService) Naming.lookup(urlPrefix + "vehicledata");
        userdata = (UserDataService) Naming.lookup(urlPrefix + "userdata");
        userlogindata = (UserLoginDataService) Naming.lookup(urlPrefix + "userlogindata");
        citydata=(CityDataService)Naming.lookup(urlPrefix + "citydata");




    }

    public static AccountDataService getAccountdata() {
        return accountdata;
    }

    public static NewBookDataService getNewbook() {
        return newbook;
    }

    public static DebitnoteFormDataService getDebitnote() {
        return debitnote;
    }

    public static RecordcollectFormDataService getRecordcollect() {
        return recordcollect;
    }

    public static RecordpayFormDataService getRecordpay() {

        return recordpay;
    }

    public static BalanceDataService getBalancedata(){
        return balancedata;
    }
    public static StatisticsDataService getStatistics(){return statistics;}
    public static CommodityDataService getCommoditydata() {
        return commoditydata;
    }

    public static StockinFormDataService getStockinform() {
        return stockinform;
    }

    public static StockoutFormDataService getStockouform() {
        return stockouform;
    }

    public static ArrivalFormDataService getArrivalform() {
        return arrivalform;
    }


    public static CenterLoadFormDataService getCenterloaddata() {
        return centerloaddata;
    }


    public static DeliveryFormDataService getDeliveryformdata() {
        return deliveryformdata;
    }


    public static GoodsReceivingFormDataService getGoodsreceiving() {
        return goodsreceiving;
    }

    public static HallLoadFormDataService getHallloadform() {
        return hallloadform;
    }

    public static LogisticsInfoService getLogisticsinfo() {
        return logisticsinfo;
    }

    public static RecordtransFormDataService getRecordtrans() {
        return recordtrans;
    }

    public static ConstantsDataService getConstantsdata() {
        return constantsdata;
    }

    public static OrganizationDataService getOrgdata() {
        return orgdata;
    }

    public static SalaryDataService getSalarydata() {
        return salarydata;
    }

    public static StaffDataService getStaffdata() {
        return staffdata;
    }

    public static LogisticsDataService getLogisticsdata() {
        return logisticsdata;
    }

    public static OrderFormDataService getOrderformdata() {
        return orderformdata;
    }

    public static DriversDataService getDriverdata() {
        return driverdata;
    }

    public static VehicleDataService getVehicledata() {
        return vehicledata;
    }

    public static UserDataService getUserdata() {
        return userdata;
    }

    public static UserLoginDataService getUserlogindata() {
        return userlogindata;
    }

    public static CityDataService getCitydata(){ return citydata;}
}
