package businesslogic.logisticsbl.ArrivalPack;

import dataservice.logisticsdataservice.ArrivalFormDataService;
import init.RMIHelper;
import po.*;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/25.
 */
public class AddArrival {
    String id;
    String centercode;
    long arrivaltime;
    boolean whefromhall;
    String transcode;
    String departure;
    Arrivalstate arrivalstate;
    Formstate documentstate;


    public void setAddArrival(String id,String centercode,long arrivaltime,boolean whefromhall, String transcode,String departure,Arrivalstate arrivalstate,Formstate documentstate){
        this.id=id;
        this.centercode=centercode;
        this.arrivaltime=arrivaltime;
        this.whefromhall=whefromhall;
        this.transcode=transcode;
        this.departure=departure;
        this.arrivalstate=arrivalstate;
        this.documentstate=documentstate;

    }


    public ResultMessage addpass(){
        ArrivalPO po=new ArrivalPO(id,centercode,arrivaltime,whefromhall,transcode,departure,arrivalstate,documentstate);
        ArrivalFormDataService dataserv= RMIHelper.getArrivalform();
        ResultMessage result=ResultMessage.failure;
        try {
             result=dataserv.addArrivalForm(po);
        } catch (RemoteException e) {
            System.out.println("Add ArrivalForm Failed!!!");
            result=ResultMessage.failure;
            e.printStackTrace();
        }
        return result;
    }
}
