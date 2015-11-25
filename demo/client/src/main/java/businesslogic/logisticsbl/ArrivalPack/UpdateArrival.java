package businesslogic.logisticsbl.ArrivalPack;

import dataservice.logisticsdataservice.ArrivalFormDataService;
import init.RMIHelper;
import po.*;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/25.
 */
public class UpdateArrival {
    String centercode;
    long arrivaltime;
    String transcode;
    Hall departure;
    Arrivalstate arrivalstate;
    Formstate documentstate;

    public void setUpdataArrival(String centercode,long arrivaltime, String transcode,Hall departure,Arrivalstate arrivalstate,Formstate documentstate){
        this.centercode=centercode;
        this.arrivaltime=arrivaltime;
        this.transcode=transcode;
        this.departure=departure;
        this.arrivalstate=arrivalstate;
        this.documentstate=documentstate;
    }


    public ResultMessage passupdate(){
        ArrivalPO po=new ArrivalPO(centercode,arrivaltime,transcode,departure,arrivalstate,documentstate);
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
