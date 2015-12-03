package businesslogic.balancebl.RecordcollectPack;

import dataservice.balancedataservice.RecordcollectFormDataService;
import init.RMIHelper;
import po.Formstate;
import po.RecordcollectPO;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Administrator on 2015/12/3.
 */
public class Findcollect {

    public List<RecordcollectPO> findforms(Formstate formstate,String orgcode){
        RecordcollectFormDataService data= RMIHelper.getRecordcollect();
        List<RecordcollectPO> pos=null;
        try {
            pos=data.getRecordcollectForm(formstate,orgcode);
        } catch (RemoteException e) {
            System.out.println("record collect get list by formstate failed!!!");
            e.printStackTrace();
        }
        return pos;


    }
}
