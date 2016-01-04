package businesslogic.logisticsbl.DeliveryPack;

import businesslogic.logisticsbl.ArrivalPack.AddArrival;
import po.DeliveryPO;
import po.Formstate;
import po.ResultMessage;
import vo.ArrivalVO;
import vo.DeliveryVO;

import javax.print.DocFlavor;
import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/11/26.
 */
public class Delivery {
    AddDelivery add;
    UpdateDelivery update;
    FindDelivery finder;
    public Delivery(AddDelivery add){
        this.add=add;
    }
    public Delivery(UpdateDelivery update){
        this.update=update;
    }
    public Delivery(FindDelivery find){this.finder=find;}

    public ResultMessage adddelivery(DeliveryVO vo){
        String id=vo.getid();
        long arrivaltime=vo.getArrivaltime();
        String barcode=vo.getBarcode();
        String delivorinfo=vo.getDelivorinfo();
        Formstate state=vo.getDocumentstate();
        add.setDelivery(id,arrivaltime,barcode,delivorinfo,state);
        ResultMessage result=add.passadd();
        return result;
    }



    public ResultMessage updatedelivery(DeliveryVO vo ){
        String id=vo.getid();
        long arrivaltime=vo.getArrivaltime();
        String barcode=vo.getBarcode();
        String delivorinfo=vo.getDelivorinfo();
        Formstate state=vo.getDocumentstate();
        update.setDelivery(id, arrivaltime, barcode, delivorinfo, state);
        ResultMessage result=update.passupdate();
        return result;

    }
    public List<DeliveryVO> find(Formstate state,String orgcode)
    {
        List<DeliveryPO > pos=finder.find(state,orgcode);
        List<DeliveryVO> list=new ArrayList<DeliveryVO>();
        int len=pos.size();
        for(int i=0;i<=len-1;i++)
        {
            DeliveryPO po=pos.get(i);

            String id=po.getId();
            long arrivaltime=po.getArrivaltime();
            String barcode=po.getBarcode();
            String delivorinfo=po.getDelivorinfo();

            Formstate documentstate=po.getDocumentstate();

            DeliveryVO vo=new DeliveryVO(id,arrivaltime,barcode,delivorinfo,documentstate);
            list.add(vo);
        }
        return list;

    }
}
