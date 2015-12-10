package businesslogic.logisticsbl.HallLoadPack;

import dataservice.logisticsdataservice.HallLoadFormDataService;
import dataservice.logisticsdataservice.LogisticsInfoService;
import init.RMIHelper;
import po.Formstate;
import po.LogisticsPO;
import po.ResultMessage;
import vo.HallLoadVO;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Administrator on 2015/11/28.
 */
public class HallloadUpdateLogistics {
    public ResultMessage updatehistory(HallLoadVO vo){
        if(vo.getstate()!= Formstate.pass){
            return ResultMessage.failure;
        }
        ResultMessage result=ResultMessage.success;
        LogisticsInfoService data=RMIHelper.getLogisticsinfo();
        List<String> allbar=vo.getAllbarcode();
        for(int i=0;i<=allbar.size()-1;i++){
            LogisticsPO po=null;
            try {
                po=data.findLogisticsInfo(allbar.get(i));

                String newstate="发往"+vo.getDestination();
                List<String> history=po.getHistory();
                history.add(newstate);
                po.setState(newstate);
                po.setHistory(history);

                ResultMessage res=data.update(po);

                if(res==ResultMessage.failure){
                    result=ResultMessage.failure;
                }

            } catch (RemoteException e) {
                System.out.println("hall load update history find logistics info failed!!!");
                e.printStackTrace();
            }







        }

        return result;

    }
}
