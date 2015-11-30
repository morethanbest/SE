package businesslogic.commoditybl.StockoutPack;

import dataservice.commoditydataservice.StockoutFormDataService;
import init.RMIHelper;
import po.Formstate;
import po.ResultMessage;
import po.StockoutPO;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/30.
 */
public class AddStockout {

    String id;
    String ordercode;
    long outtime;
    String destination;
    String transporttype;
    String transcode;

    Formstate formstate;


    public void set(String id,String ordercode,long outtime,String destination,String transporttype,String transcode,Formstate formstate){
        this.id=id;
        this.ordercode=ordercode;
        this.outtime=outtime;
        this.destination=destination;
        this.transporttype=transporttype;
        this.transcode=transcode;
        this.formstate=formstate;
    }

    public ResultMessage passadd(){
        StockoutFormDataService data= RMIHelper.getStockouform();
        StockoutPO po=new StockoutPO(id,ordercode,outtime,destination,transporttype,transcode,formstate);
        ResultMessage result=null;
        try {
            result=data.addStockoutForm(po);
        } catch (RemoteException e) {
            System.out.println("add stockout form failed!!!");
            e.printStackTrace();
        }

        return result;
    }
}
