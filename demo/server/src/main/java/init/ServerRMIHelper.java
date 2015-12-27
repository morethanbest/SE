package init;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

import data.accountdata.AccountData;
import data.accountdata.NewBookData;
import data.balancedata.BalanceData;
import data.balancedata.DebitnoteFormData;
import data.balancedata.RecordcollectFormData;
import data.balancedata.RecordpayFormData;
import data.balancedata.StatisticsData;
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
import data.managerdata.*;
import data.orderdata.LogisticsData;
import data.orderdata.OrderFormData;
import data.transportdata.DriversData;
import data.transportdata.VehicleData;
import data.userdata.UserLoginData;
import data.userdata.UsersData;

/**
 * Created by Administrator on 2015/11/23.
 */
public class ServerRMIHelper {



    private static final int PORT = 1099;

    private static boolean inited = false;

    private static RMIFactory fac=new RMIFactory();

    public synchronized static void init() throws ServerInitException {
        if (inited) {
            return;
        }
        try {
            LocateRegistry.createRegistry(PORT);
            for (Map.Entry<String, Class<? extends UnicastRemoteObject>> entry : fac.NAMING_MAP.entrySet()) {
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