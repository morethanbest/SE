package businesslogic.logisticsbl.InterfaceProvidedToOtherPackage;

import dataservice.orderdataservice.LogisticsDataService;
import init.RMIHelper;
import po.LogisticsPO;
import po.ResultMessage;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/24.
 */
public class OrderPOAdd implements OrderPOAddService{

    public ResultMessage addOrder(LogisticsPO po) {
        ResultMessage result=ResultMessage.success;
        LogisticsPO newpo=po;
        LogisticsDataService logis= RMIHelper.getLogisticsdata();
        try {
             result=logis.addLogistics(newpo);
        } catch (RemoteException e) {
            System.out.println("Add LogisticsPO failed!!!");
            result=ResultMessage.failure;
            e.printStackTrace();
        }
        return result;

    }
}
