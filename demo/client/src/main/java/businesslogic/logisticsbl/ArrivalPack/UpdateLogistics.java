package businesslogic.logisticsbl.ArrivalPack;

import dataservice.logisticsdataservice.ArrivalFormDataService;
import dataservice.logisticsdataservice.LogisticsInfoService;
import init.RMIHelper;
import po.*;
import vo.ArrivalVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/11/26.
 */
public class UpdateLogistics {

    public ResultMessage updatebyhall(ArrivalVO vo,String orgcode){///////////////////根据营业厅装车单编号  得到营业厅装车单  从而得到这批货的所有条形码号  然后修改历史轨迹


        if(vo.getFormstate()!= Formstate.pass){
            return ResultMessage.failure;
        }
        ArrivalFormDataService dataserv= RMIHelper.getArrivalform();
        HallLoadPO po=null;
        ResultMessage result=ResultMessage.success;

        List<String> allbarcode=new ArrayList<String>();

        try {
            po=dataserv.getHallLoadBycode(vo.getTranscode());
            allbarcode=po.getAllbarcode();//得到所有的订单号

        } catch (RemoteException e) {
            System.out.println("Get HallLoadPO failed!!!");
            e.printStackTrace();
        }




        LogisticsInfoService infoserv=RMIHelper.getLogisticsinfo();
        int len=allbarcode.size();
        for(int i=0;i<=len-1;i++)//依次根据订单号得到logisticspo  更新
        {
            LogisticsPO newpo=null;
            try {


                newpo=infoserv.findLogisticsInfo(allbarcode.get(i));
                String newstate="到达"+orgcode;
                newpo.setState(newstate);
                List<String> history=newpo.getHistory();
                history.add(newstate);
                newpo.setHistory(history);


            } catch (RemoteException e) {
                System.out.println("Get LogisticsPO failed!!!");
                e.printStackTrace();
            }
            ResultMessage res=ResultMessage.failure;
            try {
                res=infoserv.update(newpo);
            } catch (RemoteException e) {
                res=ResultMessage.failure;
                System.out.println("Update Logistics failed!!!");
                e.printStackTrace();
            }
            if(res==ResultMessage.failure){
                result=ResultMessage.failure;

            }

        }
        return result;


    }










    public ResultMessage updatebycenter(ArrivalVO vo,String orgcode){
        if(vo.getFormstate()!= Formstate.pass){
            return ResultMessage.failure;
        }

        ArrivalFormDataService dataserv= RMIHelper.getArrivalform();
        RecordtransPO po=null;

        List<String> allbarcode=new ArrayList<String>();
        ResultMessage result=ResultMessage.success;


        try {
            po=dataserv.getRecordtransBycode(vo.getTranscode());
            allbarcode=po.getAllcode();//得到所有的订单号

        } catch (RemoteException e) {
            System.out.println("Get TransPO failed!!!");
            e.printStackTrace();
        }

        LogisticsInfoService infoserv=RMIHelper.getLogisticsinfo();
        int len=allbarcode.size();
        for(int i=0;i<=len-1;i++)//依次根据订单号得到logisticspo  更新
        {
            LogisticsPO newpo=null;
            try {
                newpo=infoserv.findLogisticsInfo(allbarcode.get(i));
                String newstate="到达"+orgcode;
                newpo.setState(newstate);
                List<String> history=newpo.getHistory();
                history.add(newstate);
                newpo.setHistory(history);

                ResultMessage res=infoserv.update(newpo);

                if(res==ResultMessage.failure){
                    result=ResultMessage.failure;
                    break;
                }
            } catch (RemoteException e) {
                System.out.println("Get LogisticsPO failed!!!");
                e.printStackTrace();
            }




        }
        return result;

    }
}
