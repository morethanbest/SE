package businesslogic.logisticsbl.ArrivalPack;

import dataservice.logisticsdataservice.ArrivalFormDataService;
import init.RMIHelper;
import po.*;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/25.
 */
public class UpdateArrival {

    String id;
    String centercode;
    long arrivaltime;
    String transcode;
    String departure;
    Arrivalstate arrivalstate;
    Formstate documentstate;

    public void setUpdataArrival(String id,String centercode,long arrivaltime, String transcode,String departure,Arrivalstate arrivalstate,Formstate documentstate){
        this.id=id;
        this.centercode=centercode;
        this.arrivaltime=arrivaltime;
        this.transcode=transcode;
        this.departure=departure;
        this.arrivalstate=arrivalstate;
        this.documentstate=documentstate;
    }


    public ResultMessage passupdate(){
        if(this.documentstate==Formstate.pass){
            this.documentstate=Formstate.checked;
        }
        ArrivalPO po=new ArrivalPO(id,centercode,arrivaltime,transcode,departure,arrivalstate,documentstate);
        ArrivalFormDataService  dataserv= RMIHelper.getArrivalform();
        ResultMessage result=ResultMessage.failure;
        try {

            result=dataserv.updateArrivalForm(po);
        } catch (RemoteException e) {
            System.out.println("Update ArrivalForm Failed!!!");

            e.printStackTrace();
        }
        return result;
    }

}
