package businesslogic.balancebl.StatisticsPack;

import dataservice.balancedataservice.StatisticsDataService;
import init.RMIHelper;
import po.RecordpayPO;
import vo.RecordpayVO;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Administrator on 2015/12/3.
 */
public class PayGet {
    public List<RecordpayVO> getpay(long starttime,long endtime){
        StatisticsDataService data= RMIHelper.getStatistics();
        List<RecordpayPO> pos=null;
        try {
            pos=data.getallRecordpay(starttime,endtime);
        } catch (RemoteException e) {
            System.out.println("statistics get all recordpaypo failed@@@");
            e.printStackTrace();
        }
        for(int i=0;i<=pos.size()-1;i++){
            RecordpayPO po=pos.get(i);


        }
    }
}
