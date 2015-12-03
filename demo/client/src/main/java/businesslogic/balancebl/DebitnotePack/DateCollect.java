package businesslogic.balancebl.DebitnotePack;

import dataservice.balancedataservice.DebitnoteFormDataService;
import init.RMIHelper;
import po.RecordcollectPO;
import vo.RecordcollectVO;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Administrator on 2015/12/3.
 */
public class DateCollect {
    public List<RecordcollectVO> getbydate(long date){
        DebitnoteFormDataService data= RMIHelper.getDebitnote();
        List<RecordcollectPO> pos=null;
        try {
            pos=data.getRecordcollectbydate(date);
        } catch (RemoteException e) {
            System.out.println("debitnote get recordcollect by date failed!!!");
            e.printStackTrace();
        }

        TransPO tr=new TransPO();
        List<RecordcollectVO> list=tr.trans(pos);
        return list;




    }
}
