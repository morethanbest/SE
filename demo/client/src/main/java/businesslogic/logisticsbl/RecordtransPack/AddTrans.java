package businesslogic.logisticsbl.RecordtransPack;

import po.ResultMessage;

import java.util.List;

/**
 * Created by Administrator on 2015/11/26.
 */
public class AddTrans {
    private long loadtime;
    private long arrivaltime;
    private String transcode;
    private String flightcode;
    private String departrue;
    private String destination;
    private String countercode;
    private String supervisor;
    private List<String> allcode;

    public void set(long loadtime, long arrivaltime, String transcode, String flightcode, String departrue, String destination, String countercode, String supervisor, List<String> allcode){
        this.loadtime=loadtime;
        this.arrivaltime=arrivaltime;
        this.transcode=transcode;
        this.flightcode=flightcode;
        this.departrue=departrue;
        this.destination=destination;
        this.countercode=countercode;
        this.supervisor=supervisor;
        this.allcode=allcode;
    }


    public ResultMessage passadd(){

    }
}
