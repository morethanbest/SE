package businesslogic.balancebl.StatisticsPack;

import businesslogic.balancebl.RecordcollectPack.Recordcollect;
import vo.RecordcollectVO;
import vo.RecordpayVO;
import vo.StatisticsVO;

import java.util.List;

/**
 * Created by Administrator on 2015/12/3.
 */
public class BalanceStatistics {
    private CollectGet collect;
    private  PayGet pay;
    public BalanceStatistics(CollectGet collect, PayGet pay){this.collect=collect; this.pay=pay;}

    public StatisticsVO dosta(long starttime,long endtime){
        List<RecordcollectVO> collectlist=collect.getcollect(starttime,endtime);
        List<RecordpayVO> paylist=pay.getpay(starttime,endtime);
        StatisticsVO vo=new StatisticsVO(starttime,endtime,paylist,collectlist);
        return vo;
    }
}
