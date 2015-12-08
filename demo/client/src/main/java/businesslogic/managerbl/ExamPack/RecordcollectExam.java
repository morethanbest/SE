package businesslogic.managerbl.ExamPack;

import dataservice.managerdataservice.ExamDataService;
import init.RMIHelper;
import po.Formstate;
import po.RecordcollectPO;
import po.ResultMessage;
import vo.RecordcollectVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/8.
 */
public class RecordcollectExam {
    public List<RecordcollectVO> find(Formstate state){
        List<RecordcollectPO> pos=null;
        ExamDataService data= RMIHelper.getExamdata();
        try {
            pos=data.getRecordcollectForm(state);
        } catch (RemoteException e) {
            System.out.println("manager exam record collect get forms by state failed!!!");
            e.printStackTrace();
        }
        List<RecordcollectVO> list=new ArrayList<RecordcollectVO>();
        for(int i=0;i<=pos.size()-1;i++){
            RecordcollectPO po=pos.get(i);
            String id=po.getId();
            long collectiontime=po.getCollectiontime();
            String accountcode=po.getAccountcode();
            double collectionsum=po.getCollectionsum();
            String collectionman=po.getCollectionman();
            List<String> allordercode=po.getAllordercode();
            Formstate formstate=po.getDocumentstate();

            RecordcollectVO vo=new RecordcollectVO(id,collectiontime,accountcode,collectionsum,collectionman
            ,allordercode,formstate);
            list.add(vo);
        }
        return list;
        }

    public ResultMessage update(RecordcollectVO vo){
        ResultMessage result=null;
        ExamDataService data=RMIHelper.getExamdata();
        RecordcollectPO po=new RecordcollectPO(vo.getid(),vo.getCollectiontime(),vo.getAccountcode(),
                vo.getCollectionsum(),vo.getCollectionman(),vo.getAllordercode(),vo.getFormstate());
        try {
            result=data.updateRecordcollectForm(po);
        } catch (RemoteException e) {
            System.out.println("manager exam record collect updaet forms failed!!!");
            e.printStackTrace();
        }
        return result;
    }
}
