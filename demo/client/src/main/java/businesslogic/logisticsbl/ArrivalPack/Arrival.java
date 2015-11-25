package businesslogic.logisticsbl.ArrivalPack;

import po.Arrivalstate;
import po.Formstate;
import po.Hall;
import po.ResultMessage;
import vo.ArrivalVO;

/**
 * Created by Administrator on 2015/11/25.
 */
public class Arrival {
    AddArrival add;
    UpdateArrival update;

    public Arrival(AddArrival add){
        this.add=add;
    }

    public Arrival(UpdateArrival update){
        this.update=update;
    }

    public ResultMessage addArrivalForm(ArrivalVO  vo){
        String centercode=vo.getCentercode();
        long arrivaltime=vo.getArrivaltime();
        String transcode=vo.getTranscode();
        Hall departure=vo.getDeparture();

        Arrivalstate arrivalstate=vo.getArrivalstate();
        Formstate documentstate=vo.getFormstate();
        add.setAddArrival(centercode, arrivaltime, transcode, departure, arrivalstate,documentstate);
        ResultMessage result=add.addpass();
        return result;



    }

    public ResultMessage updataArrivalForm(ArrivalVO vo){
        String centercode=vo.getCentercode();
        long arrivaltime=vo.getArrivaltime();
        String transcode=vo.getTranscode();
        Hall departure=vo.getDeparture();

        Arrivalstate arrivalstate=vo.getArrivalstate();
        Formstate documentstate=vo.getFormstate();
        update.setUpdataArrival(centercode,arrivaltime,transcode,departure,arrivalstate,documentstate);
        ResultMessage result=update.passupdate();
        return result;

    }
}
