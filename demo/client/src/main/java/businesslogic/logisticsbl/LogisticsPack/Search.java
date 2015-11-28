package businesslogic.logisticsbl.LogisticsPack;

import dataservice.logisticsdataservice.LogisticsInfoService;
import init.RMIHelper;
import po.LogisticsPO;
import vo.LogisticsVO;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Administrator on 2015/11/28.
 */
public class Search {
    public LogisticsVO searchorder(String ordernum){
        LogisticsInfoService dataserv= RMIHelper.getLogisticsinfo();
        LogisticsPO po=null;
        try {
            po=dataserv.findLogisticsInfo(ordernum);
        } catch (RemoteException e) {
            System.out.println("search logistics by num failed!!!");
            e.printStackTrace();
        }
        String state=po.getState();
        List<String> history=po.getHistory();
        LogisticsVO vo=new LogisticsVO(state,history,ordernum);
        return vo;



    }
}
