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
public class UpdateGoods {
    String id;
    long arrivaltime;

    boolean whefromhall;
    String transcode;
    String departure;
    Arrivalstate arrivalstate;
    Formstate documentstate;

    public void set(String id,long arrivaltime ,boolean whefromhall,String transcode,String departure,Arrivalstate arrivalstate,Formstate documentstate){
        this.id=id;
        this.arrivaltime=arrivaltime;

        this.whefromhall=whefromhall;
        this.transcode=transcode;
        this.departure=departure;
        this.arrivalstate=arrivalstate;
        this.documentstate=documentstate;
    }

    public ResultMessage passupdate(){
        if(documentstate==Formstate.pass){
            documentstate=Formstate.checked;
        }
        GoodsReceivingFormDataService dataserv= RMIHelper.getGoodsreceiving();

        GoodsReceivingPO po=new GoodsReceivingPO(id,arrivaltime,whefromhall,transcode,departure,arrivalstate,documentstate);
        ResultMessage result=ResultMessage.failure;
        try {
            result=dataserv.updateGoodsReceivingForm(po);
        } catch (RemoteException e) {
            System.out.println("Update goodsreceving failed!!!");
            e.printStackTrace();
        }
        return result;

    }
}
