package businesslogic.logisticsbl.CenterloadPack;

import po.CenterloadPO;
import po.Formstate;
import po.ResultMessage;
import vo.CenterloadVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/11/25.
 */
public class Centerload {
    //

    AddCenterload add;
    UpdateCenterload update;
    FindCenterload find;
    public Centerload(AddCenterload add){
        this.add=add;
    }
    public Centerload(UpdateCenterload update){
        this.update=update;
    }
    public Centerload(FindCenterload find){
        this.find=find;
    }

    public ResultMessage addform(CenterloadVO vo){

        long loadtime=vo.getLoadtime();
        String motorcode=vo.getMotorcode();
        String destination=vo.getDestination();
        String vehiclecode=vo.getVehiclecode();
        String supervisor=vo.getSupervisor();
        String supercargo=vo.getSupercargo();
        List<String> allbarcode=vo.getAllbarcode();
        double fee=vo.getfee();
        Formstate documentstate=vo.getFormstate();

        add.set(loadtime,motorcode,destination,vehiclecode,supervisor,supercargo,allbarcode,fee,documentstate);//重复代码应该写成一个方法
        ResultMessage result=add.passadd();
        return result;
    }

    public ResultMessage updateform(CenterloadVO vo){

        long loadtime=vo.getLoadtime();
        String motorcode=vo.getMotorcode();
        String destination=vo.getDestination();
        String vehiclecode=vo.getVehiclecode();
        String supervisor=vo.getSupervisor();
        String supercargo=vo.getSupercargo();
        List<String> allbarcode=vo.getAllbarcode();
        double fee=vo.getfee();
        Formstate documentstate=vo.getFormstate();

        update.set(loadtime, motorcode, destination, vehiclecode, supervisor, supercargo, allbarcode, fee, documentstate);
        ResultMessage result=update.passupdate();
        return result;
    }


    public List<CenterloadVO> findforms(Formstate state,String orgcode){
        List<CenterloadVO> list=new ArrayList<CenterloadVO>();
        List<CenterloadPO> pos=find.findlist(state,orgcode);
        int len=pos.size();
        for(int i=0;i<=len-1;i++){

            CenterloadPO newpo=pos.get(i);

            long loadtime=newpo.getLoadtime();
            String motorcode=newpo.getMotorcode();
            String destination=newpo.getDestination();
            String vehiclecode=newpo.getVehiclecode();
            String supervisor=newpo.getSupervisor();
            String supercargo=newpo.getSupercargo();
            List<String> allbarcode=newpo.getAllbarcode();
            double fee=newpo.getFee();
            Formstate documentstate=newpo.getDocumentstate();

            CenterloadVO newvo=new CenterloadVO(loadtime,motorcode,destination,vehiclecode,supervisor,supercargo,allbarcode,fee,documentstate);
            list.add(newvo);

        }
        return list;
    }
}
