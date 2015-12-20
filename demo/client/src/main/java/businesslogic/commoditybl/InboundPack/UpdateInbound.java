package businesslogic.commoditybl.InboundPack;

import dataservice.commoditydataservice.CommodityDataService;
import dataservice.commoditydataservice.StockinFormDataService;
import init.RMIHelper;
import po.*;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/30.
 */
public class UpdateInbound {




    String id;
    String ordercode;
    long intime;
    CommodityLocation location;
    String destination;
    Formstate formstate;

    public void set(String id,String ordercode, long intime, CommodityLocation location,
                    String destination,Formstate formstate) {

        this.id=id;
        this.ordercode = ordercode;
        this.intime = intime;
        this.location = location;
        this.destination = destination;
        this.formstate=formstate;
    }

    public ResultMessage passupdate(){
        if(this.formstate==Formstate.checked){

            formstate=Formstate.checked;


            CommodityPO newcommodity=new CommodityPO(id,ordercode,intime,-1,destination,location);// when form is passed ,add commodity
            CommodityDataService data2=RMIHelper.getCommoditydata();
            try {
                data2.addnew(newcommodity);
                System.out.println("Add new commodity success!!!");
            } catch (RemoteException e) {
                System.out.println("Add new commodity failed!!!");
                e.printStackTrace();
            }
        }
        StockinPO newpo=new StockinPO(id,ordercode,intime,location,destination,formstate);

        StockinFormDataService data= RMIHelper.getStockinform();
        ResultMessage result=null;
        try {
            result=data.updateStockinForm(newpo);
        } catch (RemoteException e) {
            System.out.println("Update stockin form failed!!");
            e.printStackTrace();
        }
        return result;




    }
}
