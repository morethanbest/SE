package businesslogic.balancebl.DebitnotePack;

import dataservice.balancedataservice.DebitnoteFormDataService;
import init.RMIHelper;
import po.Formstate;
import po.RecordcollectPO;
import vo.RecordcollectVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/3.
 */
public class HallCollect {

    public List<RecordcollectVO> getbyhall(String orgcode){

        DebitnoteFormDataService data= RMIHelper.getDebitnote();
        List<RecordcollectPO> pos=null;
        try {
            pos=data.getRecordcollectbyhall(orgcode);
        } catch (RemoteException e) {
            System.out.println("debitenote get recordcollect by hall failed!!!");
            e.printStackTrace();
        }

        TransPO tr=new TransPO();
        List<RecordcollectVO> list=tr.trans(pos);
        return list;


    }
}
