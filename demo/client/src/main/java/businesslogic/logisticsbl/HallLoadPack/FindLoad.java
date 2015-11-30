package businesslogic.logisticsbl.HallLoadPack;

import dataservice.logisticsdataservice.HallLoadFormDataService;
import init.RMIHelper;
import po.Formstate;
import po.HallLoadPO;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Administrator on 2015/11/28.
 */
public class FindLoad {
    public List<HallLoadPO> findform(Formstate state,String orgcode){
        HallLoadFormDataService data= RMIHelper.getHallloadform();
        List<HallLoadPO> list=null;
        try {
            list=data.getLoadForm(state,orgcode);
        } catch (RemoteException e) {
            System.out.println("Find Hall load forms by state failed!!!");
            e.printStackTrace();
        }
        return list;
    }
}
