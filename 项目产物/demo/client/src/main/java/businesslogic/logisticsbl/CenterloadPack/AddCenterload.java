package businesslogic.logisticsbl.CenterloadPack;

import dataservice.logisticsdataservice.CenterLoadFormDataService;
import init.RMIHelper;
import po.CenterloadPO;
import po.Formstate;
import po.ResultMessage;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Administrator on 2015/11/25.
 */
public class AddCenterload {

    long loadtime;
    String motorcode;
    String destination;
    String vehiclecode;
    String supervisor;
    String supercargo;
    List<String> allbarcode;
    double fee;
    Formstate documentstate;

    public void set(long loadtime,String motorcode,String destination,String vehiclecode,String supervisor,String supercargo,List<String> allbarcode,double fee,Formstate state){

        this.loadtime=loadtime;
        this.motorcode=motorcode;
        this.destination=destination;
        this.vehiclecode=vehiclecode;
        this.supervisor=supervisor;
        this.supercargo=supercargo;
        this.allbarcode=allbarcode;
        this.fee=fee;
        this.documentstate=state;
    }

    public ResultMessage passadd(){
        CenterLoadFormDataService dataserv= RMIHelper.getCenterloaddata();
        ResultMessage result=null;
        CenterloadPO po=new CenterloadPO(loadtime,motorcode,destination,vehiclecode,supervisor,supercargo,allbarcode,fee,documentstate);
        try {
            result=dataserv.addCenterLoadForm(po);
        } catch (RemoteException e) {
            System.out.println("Add centerloadform failed!!!");
            e.printStackTrace();
        }
        return result;
    }
}
