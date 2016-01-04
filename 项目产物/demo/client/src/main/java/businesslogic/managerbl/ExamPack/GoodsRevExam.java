package businesslogic.managerbl.ExamPack;

import dataservice.managerdataservice.ExamDataService;
import init.RMIHelper;
import po.Arrivalstate;
import po.Formstate;
import po.GoodsReceivingPO;
import po.ResultMessage;
import vo.GoodsReceivingVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/8.
 */
public class GoodsRevExam {
    public List<GoodsReceivingVO> find(Formstate state){
        List<GoodsReceivingPO> pos=null;
        List<GoodsReceivingVO > list=new ArrayList<GoodsReceivingVO>();
        ExamDataService data= RMIHelper.getExamdata();
        try {
            pos=data.getGoodsReceivingForm(state);

            for(int i=0;i<=pos.size()-1;i++)
            {
                GoodsReceivingPO po=pos.get(i);
                String id=po.getId();
                long arrivaltime=po.getArrivaltime();

                boolean whefromhall=po.isWhefromhall();
                String transcode=po.getTranscode();
                String departure=po.getDeparture();
                Arrivalstate arrivalstate=po.getArrivalstate();
                Formstate documentstate=po.getDocumentstate();

                GoodsReceivingVO vo=new GoodsReceivingVO(id,arrivaltime,whefromhall,transcode,departure,arrivalstate,documentstate);
                list.add(vo);
            }

        } catch (RemoteException e) {
            System.out.println("manager exam goods receving forms get forms by state failed!!!");
            e.printStackTrace();
        }


        return list;

    }

    public ResultMessage update(GoodsReceivingVO vo){
        ResultMessage result=null;
        ExamDataService data=RMIHelper.getExamdata();
        GoodsReceivingPO po=new GoodsReceivingPO(vo.getid(),vo.getArrivaltime(),vo.getwhefromhalll(),vo.getTranscode(),vo.getDeparture(),vo.getArrivalstate(),
                vo.getFormstate());
        try {
            result=data.updateGoodsReceivingForm(po);
        } catch (RemoteException e) {
            System.out.println("manager exam goods receving forms update failed!!!");
            e.printStackTrace();
        }
        return result;
    }
}
