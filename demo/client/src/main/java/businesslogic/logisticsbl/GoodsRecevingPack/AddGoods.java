package businesslogic.logisticsbl.GoodsRecevingPack;

import dataservice.logisticsdataservice.GoodsReceivingFormDataService;
import init.RMIHelper;
import po.Arrivalstate;
import po.Formstate;
import po.GoodsReceivingPO;
import po.ResultMessage;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/27.
 */
public class AddGoods {
    String id;
    long arrivaltime;
    String transcode;
    String departure;
    Arrivalstate arrivalstate;
    Formstate documentstate;

    public void set(String id,long arrivaltime,String transcode,String departure,Arrivalstate arrivalstate, Formstate documentstate){
        this.id=id;
        this.arrivaltime=arrivaltime;
        this.transcode=transcode;
        this.departure=departure;
        this.arrivalstate=arrivalstate;
        this.documentstate=documentstate;
            }

    public ResultMessage passadd(){
        GoodsReceivingPO po=new GoodsReceivingPO(this.id,this.arrivaltime,this.transcode,this.departure,this.arrivalstate,this.documentstate);
        GoodsReceivingFormDataService dataserv= RMIHelper.getGoodsreceiving();
        ResultMessage result=null;
        try {
            result=dataserv.addGoodsReceivingForm(po);
        } catch (RemoteException e) {
            System.out.println("add goodsreceving failed!!!");
            e.printStackTrace();
        }
        return result;

    }
}
