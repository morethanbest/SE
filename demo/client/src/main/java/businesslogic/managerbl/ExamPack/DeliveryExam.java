package businesslogic.managerbl.ExamPack;

import dataservice.managerdataservice.ExamDataService;
import init.RMIHelper;
import po.DeliveryPO;
import po.Formstate;
import po.ResultMessage;
import vo.DeliveryVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/8.
 */
public class DeliveryExam {
    public List<DeliveryVO> find(Formstate state){
        List<DeliveryPO> pos=null;
        ExamDataService data= RMIHelper.getExamdata();
        try {
            pos=data.getDeliveryForm(state);
        } catch (RemoteException e) {
            System.out.println("manager exam delivery get forms by state failed!!!");
            e.printStackTrace();
        }


        List<DeliveryVO> list=new ArrayList<DeliveryVO>();
        for(int i=0;i<=pos.size()-1;i++){
            DeliveryPO po=pos.get(i);
            String id=po.getId();
            long arrivaltime=po.getArrivaltime();
            String barcode=po.getBarcode();
            String delivorinfo=po.getDelivorinfo();

            Formstate documentstate=po.getDocumentstate();

            DeliveryVO vo=new DeliveryVO(id,arrivaltime,barcode,delivorinfo,documentstate);
            list.add(vo);

        }
        return list;
    }

    public ResultMessage update(DeliveryVO vo){
        ResultMessage result=null;
        ExamDataService data=RMIHelper.getExamdata();
        DeliveryPO po=new DeliveryPO(vo.getid(),vo.getArrivaltime(),vo.getBarcode(),vo.getDelivorinfo(),vo.getDocumentstate());
        try {
            result=data.updateDeliveryForm(po);
        } catch (RemoteException e) {
            System.out.println("manager exam delivery forms update forms faileed!!!");
            e.printStackTrace();
        }
        return result;
    }
}
