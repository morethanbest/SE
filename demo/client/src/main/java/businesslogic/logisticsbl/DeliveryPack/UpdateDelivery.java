package businesslogic.logisticsbl.DeliveryPack;

import dataservice.logisticsdataservice.DeliveryFormDataService;
import init.RMIHelper;
import po.DeliveryPO;
import po.Formstate;
import po.ResultMessage;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/26.
 */
public class UpdateDelivery {


    String id;
    long arrivaltime;
    String barcode;
    String delivorinfo;

    Formstate documentstate;

    public void setDelivery(String id,long arrivaltime,String barcode,String delivorinfo,Formstate documentstate){
        this.id=id;
        this.arrivaltime=arrivaltime;
        this.barcode=barcode;
        this.delivorinfo=delivorinfo;

        this.documentstate=documentstate;
    }

    public ResultMessage passupdate(){

        if(this.documentstate==Formstate.pass){
            this.documentstate=Formstate.checked;
        }
        DeliveryFormDataService dataserv= RMIHelper.getDeliveryformdata();
        ResultMessage result=ResultMessage.failure;

        DeliveryPO po=new DeliveryPO(id,arrivaltime,barcode,delivorinfo,documentstate);
        try {
            result=dataserv.updateDeliveryForm(po);
        } catch (RemoteException e) {
            System.out.println("Update Delivery Failed!!!");
            e.printStackTrace();
        }
        return result;
    }
}
