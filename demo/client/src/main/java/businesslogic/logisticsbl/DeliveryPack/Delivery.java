package businesslogic.logisticsbl.DeliveryPack;

import businesslogic.logisticsbl.ArrivalPack.AddArrival;
import po.Formstate;
import po.ResultMessage;
import vo.DeliveryVO;

import javax.xml.transform.Result;

/**
 * Created by Administrator on 2015/11/26.
 */
public class Delivery {
    AddDelivery add;
    UpdateDelivery update;
    public Delivery(AddDelivery add){
        this.add=add;
    }
    public Delivery(UpdateDelivery update){
        this.update=update;
    }


    public ResultMessage adddelivery(DeliveryVO vo){
        long id=vo.getid();
        long arrivaltime=vo.getArrivaltime();
        String barcode=vo.getBarcode();
        String delivorinfo=vo.getDelivorinfo();
        Formstate state=vo.getDocumentstate();
        add.setDelivery(id,arrivaltime,barcode,delivorinfo,state);
        ResultMessage result=add.passadd();
        return result;
    }



    public ResultMessage updatedelivery(DeliveryVO vo ){
        long id=vo.getid();
        long arrivaltime=vo.getArrivaltime();
        String barcode=vo.getBarcode();
        String delivorinfo=vo.getDelivorinfo();
        Formstate state=vo.getDocumentstate();
        update.setDelivery(id, arrivaltime, barcode, delivorinfo, state);
        ResultMessage result=update.passupdate();
        return result;

    }
}
