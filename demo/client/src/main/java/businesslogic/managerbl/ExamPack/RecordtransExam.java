package businesslogic.managerbl.ExamPack;

import dataservice.managerdataservice.ExamDataService;
import init.RMIHelper;
import po.Formstate;
import po.RecordtransPO;
import po.ResultMessage;
import vo.RecordtransVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/8.
 */
public class RecordtransExam {
    public List<RecordtransVO> find(Formstate state){
        List<RecordtransPO> pos=null;
        ExamDataService data= RMIHelper.getExamdata();
        try {
            pos=data.getRecordtransForm(state);
        } catch (RemoteException e) {
            System.out.println("manager exam recordtrans get forms failed!!!");
            e.printStackTrace();
        }
        List<RecordtransVO> list=new ArrayList<RecordtransVO>();
        for(int i=0;i<=pos.size()-1;i++){
            RecordtransPO po=pos.get(i);
            long loadtime=po.getLoadtime();

            String transcode=po.getTranscode();
            String transport=po.getTransportType();//交通方式
            String transportcode=po.getTransportCode();//班次号
            String departrue=po.getDepartrue();
            String destination=po.getDestination();
            String countercode=po.getCountercode();
            String supervisor=po.getSupervisor();
            List<String> allcode=po.getAllcode();
            double fee=po.getFee();
            Formstate formstate=po.getDocumentstate();

            RecordtransVO vo=new RecordtransVO(loadtime,transcode,transport,transportcode,departrue,destination,countercode,supervisor
            ,allcode,fee,formstate);
            list.add(vo);
        }
        return list;
    }

    public ResultMessage update(RecordtransVO vo){
        ResultMessage result=null;
        ExamDataService data=RMIHelper.getExamdata();
        RecordtransPO po=new RecordtransPO(vo.getLoadtime(),vo.getTranscode(),vo.getTransportType(),vo.getTransportCode(),vo.getDepartrue(),
                vo.getDestination(),vo.getCountercode(),vo.getSupervisor(),vo.getAllcode(),vo.getfee(),vo.getFormstate());
        try {
            result=data.updateRecordtransForm(po);
        } catch (RemoteException e) {
            System.out.println("manager exam recordtrans update forms failed!!!");
            e.printStackTrace();
        }
        return result;

    }
}
