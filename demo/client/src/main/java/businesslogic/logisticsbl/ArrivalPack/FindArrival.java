package businesslogic.logisticsbl.ArrivalPack;

import dataservice.logisticsdataservice.ArrivalFormDataService;
import init.RMIHelper;
import po.ArrivalPO;
import po.Formstate;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Administrator on 2015/11/27.
 */
public class FindArrival {

    public List<ArrivalPO> find(Formstate state,String orgcode){
        ArrivalFormDataService dataserv= RMIHelper.getArrivalform();
        List<ArrivalPO> pos=null;
        try {
            pos=dataserv.getArrivalForm(state,orgcode);
        } catch (RemoteException e) {
            System.out.println("GET ARRIVALPO by state failed!!!");

            e.printStackTrace();
        }
        return pos;
    }
}
