package businesslogic.logisticsbl.CenterloadPack;

import dataservice.logisticsdataservice.CenterLoadFormDataService;
import init.RMIHelper;
import javafx.scene.input.DataFormat;
import po.TransportType;
import vo.CenterloadVO;

import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Administrator on 2015/11/28.
 */
public class FeeCounter {

    public double countfee(List<String> allbarcode, String city1, String city2){

        DecimalFormat format=new DecimalFormat("0.00");
        String transport= TransportType.truck.getName();

        CenterLoadFormDataService dataserv= RMIHelper.getCenterloaddata();
        TotalWeight weightgetter=new TotalWeight();

        double weight=weightgetter.getweight(allbarcode);


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
