package businesslogic.balancebl.StatisticsPack;

import businesslogic.balancebl.RecordcollectPack.Recordcollect;
import dataservice.balancedataservice.StatisticsDataService;
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
public class CollectGet {
    public List<RecordcollectVO> getcollect(long starttime,long endtime){
        List<RecordcollectVO> list=new ArrayList<RecordcollectVO>();
        StatisticsDataService data= RMIHelper.getStatistics();
        List<RecordcollectPO> pos=null;
        try {
            pos=data.getallRecordcollect(starttime,endtime);
            for(int i=0;i<=pos.size()-1;i++){
                RecordcollectPO po=pos.get(i);
                String id=po.getId();
                long collectiontime=po.getCollectiontime();
                String accountcode=po.getAccountcode();
                double collectionsum=po.getCollectionsum();
                String collectionman=po.getCollectionman();
                List<String> allordercode=po.getAllordercode();
                Formstate formstate=po.getDocumentstate();

                RecordcollectVO vo=new RecordcollectVO(id,collectiontime,accountcode,collectionsum,collectionman,allordercode,formstate);
                list.add(vo);


            }



        } catch (RemoteException e) {
            System.out.println("statistics get recordcollect po failed!!!");
            e.printStackTrace();
        }

        return list;


    }



}
