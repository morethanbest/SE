package init;

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
import dataservice.balancedataservice.RecordcollectFormDataService;
import dataservice.balancedataservice.RecordpayFormDataService;
import dataservice.commoditydataservice.CommodityDataService;
import dataservice.commoditydataservice.StockinFormDataService;
import dataservice.commoditydataservice.StockoutFormDataService;
import dataservice.logisticsdataservice.*;
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

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/11/23.
 */
public class ServerRMIHelper {

    private static Map<String, Class<? extends UnicastRemoteObject>> NAMING_MAP =
            new HashMap<>();

    private static final int PORT = 1099;

    private static boolean inited = false;

    static {
        NAMING_MAP.put("accountdata", AccountData.class);
        NAMING_MAP.put("newbookdata",  NewBookData.class);
        NAMING_MAP.put("debitnotedata",  DebitnoteFormData.class);
        NAMING_MAP.put("recordcollectdata",  RecordcollectFormData.class);
        NAMING_MAP.put("recordpaydata",  RecordpayFormData.class);
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



    }

    public synchronized static void init() throws ServerInitException {
        if (inited) {
            return;
        }
        try {
            LocateRegistry.createRegistry(PORT);
            for (Map.Entry<String, Class<? extends UnicastRemoteObject>> entry : NAMING_MAP.entrySet()) {
                String name = entry.getKey();
                Class<? extends UnicastRemoteObject> clazz = entry.getValue();
                UnicastRemoteObject proxy = clazz.newInstance();
                Naming.rebind(name, proxy);
            }
            inited = true;
        } catch (Exception e) {
            throw new ServerInitException(e);
        }
    }
}