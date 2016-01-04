package businesslogic.managerbl.ExamPack;

import dataservice.managerdataservice.ExamDataService;
import init.RMIHelper;
import po.Formstate;
import po.HallLoadPO;
import po.ResultMessage;
import vo.HallLoadVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/8.
 */
public class HallLoadExam {
    public List<HallLoadVO> find(Formstate state){
        List<HallLoadPO> pos=null;
        List<HallLoadVO> list=new ArrayList<HallLoadVO>();
        ExamDataService data= RMIHelper.getExamdata();
        try {
            pos=data.getLoadForm(state);

            for(int i=0;i<=pos.size()-1;i++){
                HallLoadPO po=pos.get(i);
                long loadtime=po.getLoadtime();
                String hallcode=po.getHallcode();
                String motorcode=po.getMotorcode();
                String destination=po.getDestination();
                String vehiclecode=po.getVehiclecode();
                String supervisor=po.getSupervisor();
                String supercargo=po.getSupercargo();
                List<String> allbarcode=po.getAllbarcode();
                double fee=po.getFee();
                Formstate documentstate=po.getDocumentstate();

                HallLoadVO vo=new HallLoadVO(loadtime,hallcode,motorcode,destination,vehiclecode,supervisor,supercargo
                        ,allbarcode,fee,documentstate);
                list.add(vo);
            }

        } catch (RemoteException e) {
            System.out.println("manager exam hall load get forms by state failed@!!!");
            e.printStackTrace();
        }


        return list;
    }

    public ResultMessage update(HallLoadVO vo){
        ResultMessage result=null;
        ExamDataService data=RMIHelper.getExamdata();
        HallLoadPO po=new HallLoadPO(vo.getLoadtime(),vo.getStringcode(),vo.getMotorcode(),vo.getDestination()
        ,vo.getVehicldecode(),vo.getSupervisor(),vo.getSupercargo(),vo.getAllbarcode(),vo.getfee(),vo.getstate());
        try {
            result=data.updateLoadForm(po);
        } catch (RemoteException e) {
            System.out.println("manager exam hall load update forms failed!!!");
            e.printStackTrace();
        }
        return result;
    }
}
