package businesslogic.balancebl.RecordpayPack;

import dataservice.balancedataservice.RecordpayFormDataService;
import init.RMIHelper;
import po.Formstate;
import po.RecordpayPO;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Administrator on 2015/12/3.
 */
public class FindRecord {
    public List<RecordpayPO> findforms(Formstate formstate){
        List<RecordpayPO> pos=null;
        RecordpayFormDataService data= RMIHelper.getRecordpay();
        try {
            pos=data.getRecordpayForm(formstate);
        } catch (RemoteException e) {
            System.out.println("record pay find forms by formstate!!!!");
            e.printStackTrace();
        }
        return pos;
    }
}
