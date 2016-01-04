package businesslogic.logisticsbl.HallLoadPack;

import po.Formstate;
import po.HallLoadPO;
import po.ResultMessage;
import vo.HallLoadVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/11/28.
 */
public class HallLoad {
    AddLoad add;
    UpdateLoad update;
    FindLoad find;
    public HallLoad(AddLoad add){
        this.add=add;
    }
    public HallLoad(UpdateLoad update){
        this.update=update;
    }
    public HallLoad(FindLoad find){
        this.find=find;
    }
    public ResultMessage addform(HallLoadVO vo){
        long loadtime=vo.getLoadtime();
        String hallcode=vo.getStringcode();
        String motorcode=vo.getMotorcode();
        String destination=vo.getDestination();
        String vehiclecode=vo.getVehicldecode();
        String supervisor=vo.getSupervisor();
        String supercargo=vo.getSupercargo();
        List<String> allbarcode=vo.getAllbarcode();
        double fee=vo.getfee();
        Formstate documentstate=vo.getstate();

        add.set(loadtime,hallcode,motorcode,destination,vehiclecode,supervisor,supercargo,allbarcode,fee,documentstate);
        ResultMessage result=add.passadd();
        return result;

    }

    public ResultMessage updateform(HallLoadVO vo){
        long loadtime=vo.getLoadtime();
        String hallcode=vo.getStringcode();
        String motorcode=vo.getMotorcode();
        String destination=vo.getDestination();
        String vehiclecode=vo.getVehicldecode();
        String supervisor=vo.getSupervisor();
        String supercargo=vo.getSupercargo();
        List<String> allbarcode=vo.getAllbarcode();
        double fee=vo.getfee();
        Formstate documentstate=vo.getstate();

        update.set(loadtime, hallcode, motorcode, destination, vehiclecode, supervisor, supercargo, allbarcode, fee, documentstate);
        ResultMessage result=update.passupdate();
        return result;
    }

    public List<HallLoadVO> findforms(Formstate state,String orgcode){
        List<HallLoadVO> list=new ArrayList<HallLoadVO>();
        List<HallLoadPO> pos=find.findform(state,orgcode);
        for(int i=0;i<=pos.size()-1;i++){
            HallLoadPO po=pos.get(i);
            long loadtime=po.getLoadtime();
            String hallcode=po.getHallcode();
            String motorcode=po.getMotorcode();
            String destination=po.getDestination();
            String vehiclecode=po.getVehicldecode();
            String supervisor=po.getSupervisor();
            String supercargo=po.getSupercargo();
            List<String> allbarcode=po.getAllbarcode();
            double fee=po.getFee();
            Formstate documentstate=po.getstate();

            HallLoadVO vo=new HallLoadVO(loadtime,hallcode,motorcode,destination,vehiclecode,supervisor,supercargo,allbarcode,fee,documentstate);
            list.add(vo);
        }
        return list;
    }
}
