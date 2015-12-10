package businesslogic.balancebl.StatisticsPack;

import dataservice.balancedataservice.StatisticsDataService;
import init.RMIHelper;
import po.Formstate;
import po.RecordpayList;
import po.RecordpayPO;
import vo.RecordpayVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/3.
 */
public class PayGet {
    public List<RecordpayVO> getpay(long starttime,long endtime){
        List<RecordpayVO> list=new ArrayList<RecordpayVO>();
        StatisticsDataService data= RMIHelper.getStatistics();
        List<RecordpayPO> pos=null;
        try {
            pos=data.getallRecordpay(starttime,endtime);

            for(int i=0;i<=pos.size()-1;i++){
                RecordpayPO po=pos.get(i);

                String id=po.getId();
                long paytime=po.getPaytime();
                double paysum=po.getPaysum();
                String payman=po.getPayman();
                String payaccount=po.getPayaccount();
                RecordpayList entry=po.getEntry();
                String remark=po.getRemark();
                Formstate formstate=po.getFormstate();

                RecordpayVO vo=new RecordpayVO(id,paytime,paysum,payman,payaccount,entry,remark,formstate);
                list.add(vo);

            }


        } catch (RemoteException e) {
            System.out.println("statistics get all recordpaypo failed@@@");
            e.printStackTrace();
        }

        return list;
    }
}
