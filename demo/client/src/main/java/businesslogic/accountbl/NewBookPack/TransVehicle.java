package businesslogic.accountbl.NewBookPack;

import businesslogic.transportbl.VehiclePack.Vehicle;
import po.VehiclesPO;
import vo.VehicleVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/8.
 */
public class TransVehicle {
    public List<VehicleVO> trans(List<VehiclesPO> po){
        List<VehicleVO> list=new ArrayList<VehicleVO>();
        for(int i=0;i<=po.size()-1;i++){
            VehiclesPO newpo=po.get(i);
            String vehiclecode=newpo.getVehiclecode();
            String platenum=newpo.getVehiclenum();
            long extendtime=newpo.getExtendtime();

            VehicleVO vo=new VehicleVO(vehiclecode,platenum,extendtime);
            list.add(vo);
        }
        return list;
    }

    public List<VehiclesPO> trans2(List<VehicleVO> vo){
        List<VehiclesPO> list=new ArrayList<VehiclesPO>();
        for(int i=0;i<=vo.size()-1;i++){
            VehicleVO newvo=vo.get(i);
            String vehiclecode=newvo.getVehiclecode();
            String platenum=newvo.getVehiclenum();
            long extendtime=newvo.getExtendtime();

            VehiclesPO po=new VehiclesPO(vehiclecode,platenum,extendtime);
            list.add(po);

        }
        return list;
    }
}
