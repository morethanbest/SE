package businesslogic.commoditybl.StockoutPack;

import dataservice.commoditydataservice.CommodityDataService;
import dataservice.commoditydataservice.StockoutFormDataService;
import init.RMIHelper;
import po.CommodityPO;
import po.Formstate;
import po.ResultMessage;
import po.StockoutPO;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/30.
 */
public class UpdateStockout {

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

    public ResultMessage passupdate(){
        String orgcode=id.substring(0,id.length()-7);//////////////////////////get orgcode   may run wrong
        if(formstate==Formstate.checked){
            this.formstate=Formstate.checked;
            CommodityDataService data2=RMIHelper.getCommoditydata();
            CommodityPO po=null;
            try {
                po=data2.getCommodityByCode(orgcode,ordercode);
            } catch (RemoteException e) {
                System.out.println("stockout update commodity po get commoditypo failed!!!");
                e.printStackTrace();
            }

            try {
            	po.setOuttime(outtime);
                if(ResultMessage.success==data2.setOuttime(po,outtime)){
                	System.out.println(po.getOuttime());
                }
            } catch (RemoteException e) {
                System.out.println("stock out update commmodity set out time failed!!!");
                e.printStackTrace();
            }


        }



        StockoutFormDataService data= RMIHelper.getStockouform();
        StockoutPO po=new StockoutPO(id,ordercode,outtime,destination,transporttype,transcode,formstate);
        ResultMessage result=null;

        try {
            result=data.updateStockoutForm(po);
        } catch (RemoteException e) {
            System.out.println("update stockout form failed!!!");
            e.printStackTrace();
        }

        return result;
    }
}
