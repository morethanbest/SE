package businesslogic.logisticsbl.HallLoadPack;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ResultTreeType;
import dataservice.logisticsdataservice.HallLoadFormDataService;
import init.RMIHelper;
import po.Formstate;
import po.HallLoadPO;
import po.ResultMessage;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Administrator on 2015/11/28.
 */
public class UpdateLoad {
    long loadtime;
    String hallcode;
    String motorcode;
    String destination;
    String vehiclecode;
    String supervisor;
    String supercargo;
    List<String> allbarcode;
    double fee;
    Formstate documentstate;

    public void set(long loadtime,String  hallcode,String motorcode,String destination,String vehiclecode, String supervisor,String supercargo,List<String> allbarcode,double fee,Formstate formstate){
        this.loadtime=loadtime;
        this.hallcode=hallcode;
        this.motorcode=motorcode;
        this.destination=destination;
        this.vehiclecode=vehiclecode;
        this.supervisor=supervisor;
        this.supercargo=supercargo;
        this.allbarcode=allbarcode;
        this.fee=fee;
        this.documentstate=formstate;
    }

    public ResultMessage passupdate(){
        HallLoadPO po=new HallLoadPO(loadtime,hallcode,motorcode,destination,vehiclecode,supervisor,supercargo,allbarcode,fee,documentstate);
        HallLoadFormDataService data= RMIHelper.getHallloadform();
        ResultMessage result=null;
        try {
            result=data.updateLoadForm(po);
        } catch (RemoteException e) {
            System.out.println("Update hall load form failed!!!");
            e.printStackTrace();
        }
        return result;
    }
}
