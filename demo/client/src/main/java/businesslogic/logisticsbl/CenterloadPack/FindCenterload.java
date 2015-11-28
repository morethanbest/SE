package businesslogic.logisticsbl.CenterloadPack;

import dataservice.logisticsdataservice.CenterLoadFormDataService;
import init.RMIHelper;
import po.CenterloadPO;
import po.Formstate;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Administrator on 2015/11/28.
 */
public class FindCenterload {

    public List<CenterloadPO> findlist(Formstate state){
        CenterLoadFormDataService dataserv= RMIHelper.getCenterloaddata();
        List<CenterloadPO> pos=null;
        try {
            pos=dataserv.getCenterLoadForm(state);
        } catch (RemoteException e) {
            System.out.println("get centerload form list by formstate failed!!!");
            e.printStackTrace();
        }
        return pos;
    }
}
