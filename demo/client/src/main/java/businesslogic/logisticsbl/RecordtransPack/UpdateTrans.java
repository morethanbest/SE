package businesslogic.logisticsbl.RecordtransPack;

import dataservice.logisticsdataservice.CenterLoadFormDataService;
import dataservice.logisticsdataservice.RecordtransFormDataService;
import init.RMIHelper;
import po.Formstate;
import po.RecordtransPO;
import po.ResultMessage;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Administrator on 2015/11/26.
 */
public class UpdateTrans {
    private long loadtime;
    private long arrivaltime;
    private String transcode;
    String transport;//交通方式
    String transportcode;//班次号
    private String departrue;
    private String destination;
    private String countercode;
    private String supervisor;
    private List<String> allcode;
    private double fee;
    Formstate formstate;

    public void set(long loadtime, long arrivaltime, String transcode, String transport,String transportcode, String departrue, String destination, String countercode, String supervisor, List<String> allcode,double fee,Formstate state){
        this.loadtime=loadtime;
        this.arrivaltime=arrivaltime;
        this.transcode=transcode;
        this.transport=transport;
        this.transportcode=transportcode;
        this.departrue=departrue;
        this.destination=destination;
        this.countercode=countercode;
        this.supervisor=supervisor;
        this.allcode=allcode;
        this.fee=fee;
        this.formstate=state;
    }

    public ResultMessage passupdate(){
        if(this.formstate==Formstate.pass){
            this.formstate=Formstate.checked;
        }
        RecordtransFormDataService dataserv= RMIHelper.getRecordtrans();
        RecordtransPO po=new RecordtransPO(loadtime,arrivaltime,transcode,transport,transportcode,departrue,destination,countercode,supervisor,allcode,fee,formstate);
        ResultMessage result=null;
        try {
            result=dataserv.updateRecordtransForm(po);
        } catch (RemoteException e) {
            System.out.println("update recordtrans form failed!!!");
            e.printStackTrace();
        }
        return result;


    }
}
