package businesslogic.logisticsbl.GoodsRecevingPack;

import dataservice.logisticsdataservice.GoodsReceivingFormDataService;
import dataservice.logisticsdataservice.LogisticsInfoService;
import init.RMIHelper;
import po.*;
import vo.GoodsReceivingVO;

import java.rmi.RemoteException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/11/28.
 */
public class GoodsRevUpdateLogistics {

    public ResultMessage updatabyhall(GoodsReceivingVO vo,String orgname){//如果这次的货物是由营业厅来的
        if(vo.getFormstate()!= Formstate.pass){
            return ResultMessage.failure;
        }
        GoodsReceivingFormDataService dataserv= RMIHelper.getGoodsreceiving();
        HallLoadPO hallload=null;

        List<String> allbarcode=new ArrayList<String>();
        ResultMessage result=ResultMessage.failure;
        try {


            hallload=dataserv.getHallLoadBycode(vo.getTranscode());
            allbarcode=hallload.getAllbarcode();


        } catch (RemoteException e) {
            System.out.println("update goodsreceving logistics information failed!!!");
            e.printStackTrace();
        }





        LogisticsInfoService infoserv=RMIHelper.getLogisticsinfo();


        int len=allbarcode.size();
        for(int i=0;i<=len-1;i++)//依次根据订单号得到logisticspo  更新
        {
            LogisticsPO newpo=null;
            try {


                newpo=infoserv.findLogisticsInfo(allbarcode.get(i));
                String newstate="到达"+orgname;
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
                break;
            }

        }
        return result;


    }



    public ResultMessage updatebycenter(GoodsReceivingVO vo,String orgname){
        if(vo.getFormstate()!= Formstate.pass){
            return ResultMessage.failure;
        }
        GoodsReceivingFormDataService dataserv= RMIHelper.getGoodsreceiving();

        CenterloadPO centerload=null;
        ResultMessage result=ResultMessage.failure;
        try {
            centerload=dataserv.getCenterLoadBycode(vo.getTranscode());
        } catch (RemoteException e) {
            System.out.println("update goodsreceving logistics information failed!!!");
            e.printStackTrace();
        }

        List<String> allbarcode=centerload.getAllbarcode();

        LogisticsInfoService infoserv=RMIHelper.getLogisticsinfo();


        int len=allbarcode.size();
        for(int i=0;i<=len-1;i++)//依次根据订单号得到logisticspo  更新
        {
            LogisticsPO newpo=null;
            try {


                newpo=infoserv.findLogisticsInfo(allbarcode.get(i));
                String newstate="到达"+orgname;
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


}
