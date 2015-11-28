package businesslogic.logisticsbl.CenterloadPack;

import dataservice.logisticsdataservice.CenterLoadFormDataService;
import init.RMIHelper;
import javafx.scene.input.DataFormat;
import vo.CenterloadVO;

import java.rmi.RemoteException;
import java.text.DecimalFormat;

/**
 * Created by Administrator on 2015/11/28.
 */
public class FeeCounter {

    public double countfee(CenterloadVO vo, String city1, String city2, String transport){

        DecimalFormat format=new DecimalFormat("0.00");


        CenterLoadFormDataService dataserv= RMIHelper.getCenterloaddata();
        TotalWeight weightgetter=new TotalWeight();
        double weight=weightgetter.getweight(vo);
        double singleprice=0;
        try {
            singleprice=dataserv.getunitprice(transport);
        } catch (RemoteException e) {
            System.out.println("get single price failed while countint fee!!!");
            e.printStackTrace();
        }

        double distance=0;
        try {
            distance=dataserv.getdistance(city1,city2);
        } catch (RemoteException e) {
            System.out.println("get distance failed while countint fee!!!");
            e.printStackTrace();
        }



        double fee=weight*singleprice*distance;
        fee=Long.valueOf(format.format(fee));
        return fee;
    }
}
