package businesslogic.managerbl.ExamPack;

import dataservice.managerdataservice.ExamDataService;
import init.RMIHelper;
import po.CenterloadPO;
import po.Formstate;
import po.ResultMessage;
import vo.CenterloadVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/8.
 */
public class CenterLoadExam {
    public List<CenterloadVO> find(Formstate state){
        List<CenterloadPO> pos=null;
        List<CenterloadVO> list=new ArrayList<CenterloadVO>();
        ExamDataService data= RMIHelper.getExamdata();
        try {
            pos=data.getCenterLoadForm(state);
        } catch (RemoteException e) {
            System.out.println("manager exam centerload get forms failed!!!");
            e.printStackTrace();
        }

        for(int i=0;i<=pos.size()-1;i++){
            CenterloadPO po=pos.get(i);
            long loadtime=po.getLoadtime();
            String motorcode=po.getMotorcode();
            String destination=po.getDestination();
            String vehiclecode=po.getVehiclecode();
            String supervisor=po.getSupervisor();
            String supercargo=po.getSupercargo();
            List<String> allbarcode=po.getAllbarcode();
            double fee=po.getFee();
            Formstate documentstate=po.getDocumentstate();

            CenterloadVO vo=new CenterloadVO(loadtime,motorcode,destination,vehiclecode,supervisor,supercargo,allbarcode
                    ,fee,documentstate);
            list.add(vo);

        }
        return list;


    }

    public ResultMessage update(CenterloadVO vo){
        ResultMessage result=null;
        ExamDataService data= RMIHelper.getExamdata();
        CenterloadPO po=new CenterloadPO(vo.getLoadtime(),vo.getMotorcode(),vo.getDestination(),vo.getVehiclecode(),
                vo.getSupervisor(),vo.getSupercargo(),vo.getAllbarcode(),vo.getfee(),vo.getFormstate());
        try {
            result=data.updateCenterLoadForm(po);
        } catch (RemoteException e) {
            System.out.println("manager exam centerload update failed!!!");
            e.printStackTrace();
        }
        return result;
    }
}
