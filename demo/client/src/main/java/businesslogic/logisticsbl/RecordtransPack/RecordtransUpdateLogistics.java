package businesslogic.logisticsbl.RecordtransPack;

import dataservice.logisticsdataservice.LogisticsInfoService;
import dataservice.logisticsdataservice.RecordtransFormDataService;
import init.RMIHelper;
import po.LogisticsPO;
import po.ResultMessage;
import vo.RecordtransVO;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Administrator on 2015/11/28.
 */
public class RecordtransUpdateLogistics {

    public ResultMessage updatehistory(RecordtransVO vo){
        ResultMessage result=ResultMessage.success;
        LogisticsInfoService dataserv=RMIHelper.getLogisticsinfo();
        List<String> allbar=vo.getAllcode();
        int len=allbar.size();
        for(int i=0;i<=len-1;i++)
        {
            LogisticsPO newpo=null;
            try {
                newpo=dataserv.findLogisticsInfo(allbar.get(i));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            String nowstate="发往"+vo.getDepartrue();
            List<String> history=newpo.getHistory();
            history.add(nowstate);
            newpo.setHistory(history);
            newpo.setState(nowstate);
            ResultMessage res=null;
            try {
                res=dataserv.update(newpo);
            } catch (RemoteException e) {
                System.out.println(" recordtrans update logistics failed!!!");
                e.printStackTrace();
            }
            if(res==ResultMessage.failure){
                result=ResultMessage.failure;
            }


        }
        return result;
    }
}