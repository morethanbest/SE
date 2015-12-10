package businesslogic.managerbl.ExamPack;

import dataservice.managerdataservice.ExamDataService;
import init.RMIHelper;
import po.Formstate;
import po.RecordpayList;
import po.RecordpayPO;
import po.ResultMessage;
import vo.RecordpayVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/8.
 */
public class RecordpayExam {
    public List<RecordpayVO> find(Formstate state){
        List<RecordpayPO> pos=null;
        List<RecordpayVO> list=new ArrayList<RecordpayVO>();

        ExamDataService data= RMIHelper.getExamdata();
        try {
            pos=data.getRecordpayForm(state);

            for(int i=0;i<=pos.size()-1;i++){
                RecordpayPO po=pos.get(i);
                String id=po.getId();
                long paytime=po.getPaytime();
                double paysum=po.getPaysum();
                String payman=po.getPayman();
                String payaccount=po.getPayaccount();
                RecordpayList entry=po.getEntry();
                String remark=po.getRemark();
                Formstate formstate=po.getFormstate();

                RecordpayVO vo=new RecordpayVO(id,paytime,paysum,payman,payaccount,entry,remark,formstate);
                list.add(vo);

            }


        } catch (RemoteException e) {
            System.out.println("manager exam record pay get forms failed!!!");
            e.printStackTrace();
        }


        return list;
    }

    public ResultMessage update(RecordpayVO vo){
        ResultMessage result=null;
        ExamDataService data=RMIHelper.getExamdata();
        RecordpayPO po=new RecordpayPO(vo.getId(),vo.getPaytime(),vo.getPaysum(),vo.getPayman(),vo.getPayaccount()
        ,vo.getEntry(),vo.getRemark(),vo.getFormstate());
        try {
            result=data.updateRecordpayForm(po);
        } catch (RemoteException e) {
            System.out.println("manager exam recordpay update forms failed!!!");
            e.printStackTrace();
        }
        return result;
    }
}
