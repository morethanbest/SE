package businesslogic.logisticsbl.CenterloadPack;

import dataservice.logisticsdataservice.LogisticsInfoService;
import init.RMIHelper;
import po.Formstate;
import po.LogisticsPO;
import po.ResultMessage;
import vo.CenterloadVO;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Administrator on 2015/11/28.
 */
public class CenterloadUpdateLogistics {

    public ResultMessage updatehistory(CenterloadVO vo)
    {
        if(vo.getFormstate()!= Formstate.checked){
            return ResultMessage.failure;
        }


        ResultMessage result=ResultMessage.success;
        List<String> allbarcode=vo.getAllbarcode();
        String destination=vo.getDestination();
        int len=allbarcode.size();


        LogisticsInfoService dataserv= RMIHelper.getLogisticsinfo();

        for(int i=0;i<=len-1;i++)
        {
            LogisticsPO po=null;
            try {
                po=dataserv.findLogisticsInfo(allbarcode.get(i));

                List<String> history=po.getHistory();
                String state="已发往"+destination;
                history.add(state);
                po.setHistory(history);
                po.setState(state);

                ResultMessage res=dataserv.update(po);

                if(res==ResultMessage.failure)
                {
                    result=ResultMessage.failure;
                }


            } catch (RemoteException e) {
                System.out.println("centerload update history get logisticspo failed!!!");
                e.printStackTrace();
            }










        }

        return result;

    }
}
