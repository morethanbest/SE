package businesslogic.logisticsbl.ArrivalPack;

import po.ArrivalPO;
import po.Arrivalstate;
import po.Formstate;
import po.ResultMessage;
import vo.ArrivalVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/11/25.
 */
public class Arrival {
    AddArrival add;
    UpdateArrival update;
    FindArrival find;

    public Arrival(AddArrival add){
        this.add=add;
    }

    public Arrival(UpdateArrival update){
        this.update=update;
    }

    public Arrival(FindArrival find){ this.find=find;}
    public ResultMessage addArrivalForm(ArrivalVO  vo){
        String id=vo.getId();
        String centercode=vo.getCentercode();
        long arrivaltime=vo.getArrivaltime();
        String transcode=vo.getTranscode();
        String departure=vo.getDeparture();

        Arrivalstate arrivalstate=vo.getArrivalstate();
        Formstate documentstate=vo.getFormstate();
        add.setAddArrival(id,centercode, arrivaltime, transcode, departure, arrivalstate,documentstate);
        ResultMessage result=add.addpass();
        return result;



    }

    public ResultMessage updataArrivalForm(ArrivalVO vo){
        String id=vo.getId();
        String centercode=vo.getCentercode();
        long arrivaltime=vo.getArrivaltime();
        String transcode=vo.getTranscode();
        String departure=vo.getDeparture();

        Arrivalstate arrivalstate=vo.getArrivalstate();
        Formstate documentstate=vo.getFormstate();
        update.setUpdataArrival(id,centercode,arrivaltime,transcode,departure,arrivalstate,documentstate);
        ResultMessage result=update.passupdate();
        return result;

    }

    public List<ArrivalVO> findArrivalForm(Formstate state,String orgcode)
    {

        List<ArrivalPO> po=find.find(state,orgcode);
        List<ArrivalVO> list=new ArrayList<ArrivalVO>();
        int len=po.size();
        for(int i=0;i<=len-1;i++)
        {
            ArrivalPO a=po.get(i);
            String id=a.getId();
            String centercode=a.getCentercode();
            long arrivaltime=a.getArrivaltime();
            String transcode=a.getTranscode();
            String departure=a.getDeparture();
            Arrivalstate arrivalstate=a.getArrivalstate();
            Formstate documentstate=a.getDocumentstate();
            ArrivalVO newvo=new ArrivalVO(id,centercode,arrivaltime,transcode,departure,arrivalstate,documentstate);
            list.add(newvo);

        }
        return list;
    }
}
