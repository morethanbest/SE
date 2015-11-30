package businesslogic.logisticsbl.RecordtransPack;

import dataservice.logisticsdataservice.RecordtransFormDataService;
import init.RMIHelper;
import po.Formstate;
import po.RecordtransPO;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Administrator on 2015/11/28.
 */
public class FindTrans {

    public List<RecordtransPO> findforms(Formstate state,String orgcode){
        RecordtransFormDataService data= RMIHelper.getRecordtrans();
        List<RecordtransPO> pos=null;
        try {
            pos=data.getRecordtransForm(state,orgcode);
        } catch (RemoteException e) {
            System.out.println("find recordtrans forms by  state failed!!!");
            e.printStackTrace();
        }
        return pos;
    }
}
