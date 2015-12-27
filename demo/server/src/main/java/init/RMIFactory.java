package init;

import data.accountdata.AccountData;
import data.accountdata.NewBookData;
import data.balancedata.*;
import data.commoditydata.CommodityData;
import data.commoditydata.StockinFormData;
import data.commoditydata.StockoutFormData;
import data.logisticsdata.*;
import data.managerdata.*;
import data.orderdata.LogisticsData;
import data.orderdata.OrderFormData;
import data.transportdata.DriversData;
import data.transportdata.VehicleData;
import data.userdata.UserLoginData;
import data.userdata.UsersData;

import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/12/27.
 */
public class RMIFactory {
    public static Map<String, Class<? extends UnicastRemoteObject>> NAMING_MAP =
            new HashMap<>();

    static {
        NAMING_MAP.put("accountdata", AccountData.class);
        NAMING_MAP.put("newbookdata",  NewBookData.class);
        NAMING_MAP.put("debitnotedata",  DebitnoteFormData.class);
        NAMING_MAP.put("recordcollectdata",  RecordcollectFormData.class);
        NAMING_MAP.put("recordpaydata",  RecordpayFormData.class);
        NAMING_MAP.put("balancedata",  BalanceData.class);
        NAMING_MAP.put("statistics",  StatisticsData.class);


        NAMING_MAP.put("commoditydata",  CommodityData.class);
        NAMING_MAP.put("stockindata",  StockinFormData.class);
        NAMING_MAP.put("stockoutdata",  StockoutFormData.class);
        NAMING_MAP.put("arrivaldata",  ArrivalFormData.class);
        NAMING_MAP.put("centerloaddata",  CenterLoadFormData.class);
        NAMING_MAP.put("deliverydata",  DeliveryFormData.class);
        NAMING_MAP.put("goodsdata",  GoodsReceivingFormData.class);
        NAMING_MAP.put("hallloaddata",  HallLoadFormData.class);
        NAMING_MAP.put("logisticsinfodata",  LogisticsInfo.class);
        NAMING_MAP.put("recordtransdata",  RecordtransFormData.class);
        NAMING_MAP.put("constantsdata",  ConstantsData.class);
        NAMING_MAP.put("orgdata",  OrganizationData.class);
        NAMING_MAP.put("salarydata",  SalaryData.class);
        NAMING_MAP.put("staffdata",  StaffData.class);
        NAMING_MAP.put("logisticsdata",  LogisticsData.class);
        NAMING_MAP.put("orderformdata",  OrderFormData.class);
        NAMING_MAP.put("driverdata",  DriversData.class);
        NAMING_MAP.put("vehicledata",  VehicleData.class);
        NAMING_MAP.put("userdata",  UsersData.class);
        NAMING_MAP.put("userlogindata",  UserLoginData.class);
        NAMING_MAP.put("citydata",  CityData.class);
        NAMING_MAP.put("examdata",  ExamData.class);
        NAMING_MAP.put("managerbalance",  ManagerBalanceData.class);


    }
}
