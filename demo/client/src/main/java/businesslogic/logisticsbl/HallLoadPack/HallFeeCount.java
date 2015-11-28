package businesslogic.logisticsbl.HallLoadPack;

import dataservice.logisticsdataservice.HallLoadFormDataService;
import init.RMIHelper;
import vo.HallLoadVO;

import java.rmi.RemoteException;
import java.text.DecimalFormat;

/**
 * Created by Administrator on 2015/11/29.
 */
public class HallFeeCount {
    public double countfee(HallLoadVO vo, String City1, String City2, String transporttype){
        HallloadTotalWeight wei=new HallloadTotalWeight();
        double weight=wei.getweight(vo);
        HallLoadFormDataService data= RMIHelper.getHallloadform();
        double distance=0;
        try {
            distance=data.getdistance(City1,City2);
        } catch (RemoteException e) {
            System.out.println("hall load count fee get distance failed");
            e.printStackTrace();
        }

        double singleprice=0;
        try {
            singleprice=data.getunitprice(transporttype);
        } catch (RemoteException e) {
            System.out.println("hall load count fee get single price failed");
            e.printStackTrace();
        }


        double fee=weight*distance*singleprice;
        DecimalFormat format=new DecimalFormat("0.00");
        fee=Long.valueOf(format.format(fee));
        return fee;
    }
}
