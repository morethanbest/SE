package businesslogic.managerbl.ExamPack;

import businesslogic.logisticsbl.ArrivalPack.Arrival;
import dataservice.managerdataservice.ExamDataService;
import init.RMIHelper;
import po.ArrivalPO;
import po.Arrivalstate;
import po.Formstate;
import po.ResultMessage;
import vo.ArrivalExamVO;
import vo.ArrivalVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/7.
 */
public class ArrivalExam {
    public List<ArrivalVO> find(Formstate formstate){
        List<ArrivalPO> pos=null;
        ExamDataService data= RMIHelper.getExamdata();
        try {
            pos=data.getArrivalForm(formstate);
        } catch (RemoteException e) {
            System.out.println("manager exam  get arrival forms failed!!!");
            e.printStackTrace();
        }
        List<ArrivalVO> list=new ArrayList<ArrivalVO>();
        for(int i=0;i<=pos.size()-1;i++){
            ArrivalPO po=pos.get(i);
            String  id=po.getId();
            String centercode=po.getCentercode();
            long arrivaltime=po.getArrivaltime();
            String transcode=po.getTranscode();

            String departure=po.getDeparture();
            Arrivalstate arrivalstate=po.getArrivalstate();
            Formstate documentstate=po.getDocumentstate();

            ArrivalVO vo=new ArrivalVO(id,centercode,arrivaltime,transcode,departure,arrivalstate,documentstate);
            list.add(vo);
        }

        return list;

    }

    public ResultMessage update(ArrivalVO vo){
        ResultMessage result=null;
        ExamDataService data= RMIHelper.getExamdata();
        ArrivalPO po=new ArrivalPO(vo.getId(),vo.getCentercode(),vo.getArrivaltime(),vo.getTranscode(),
                vo.getDeparture(),vo.getArrivalstate(),vo.getFormstate());
        try {
            result=data.updateArrivalForm(po);
        } catch (RemoteException e) {
            System.out.println("manager exam arrival update failed!!!");
            e.printStackTrace();
        }
        return result;
    }
}
