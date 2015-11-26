package businesslogic.logisticsbl.DeliveryPack;

import dataservice.balancedataservice.DebitnoteFormDataService;
import dataservice.logisticsdataservice.DeliveryFormDataService;
import dataservice.orderdataservice.LogisticsDataService;
import init.RMIHelper;
import po.DeliveryPO;
import po.Formstate;
import po.ResultMessage;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/26.
 */
public class AddDelivery {
    long id;
    long arrivaltime;
    String barcode;
    String delivorinfo;

    Formstate documentstate;
    public void setDelivery(long id,long arrivaltime,String barcode,String delivorinfo,Formstate documentstate){
        this.id=id;
        this.arrivaltime=arrivaltime;
        this.barcode=barcode;
        this.delivorinfo=delivorinfo;

        this.documentstate=documentstate;
    }



    public ResultMessage passadd(){
        DeliveryFormDataService dataserv=RMIHelper.getDeliveryformdata();
        ResultMessage result=ResultMessage.failure;
        DeliveryPO po=new DeliveryPO(id,arrivaltime,barcode,delivorinfo,documentstate);
        try {
            result=dataserv.addDeliveryForm(po);
        } catch (RemoteException e) {
            System.out.println("Add DeliveryForm Failed!!!");
            e.printStackTrace();
        }
        return result;
    }
}
