package businesslogic.logisticsbl.DeliveryPack;

import dataservice.balancedataservice.DebitnoteFormDataService;
import dataservice.logisticsdataservice.DeliveryFormDataService;
import init.RMIHelper;
import po.DeliveryPO;
import po.Formstate;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Administrator on 2015/11/27.
 */
public class FindDelivery {
    public List<DeliveryPO> find(Formstate state,String orgcode){
        DeliveryFormDataService dataserv=RMIHelper.getDeliveryformdata();
        List<DeliveryPO> pos=null;
        try {
            pos=dataserv.getDeliveryForm(state,orgcode);
        } catch (RemoteException e) {
            System.out.println("find delivery failed!!!");

            e.printStackTrace();
        }
        return pos;
    }
}
