package businesslogic.logisticsbl.StategyPack;

import dataservice.logisticsdataservice.CenterLoadFormDataService;
import init.RMIHelper;
import po.TransportType;

import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Administrator on 2015/12/27.
 */
public class FeeStategyByTruck implements  FeeInterface{

    @Override
    public double getfee(List<String> allbarcode, String city1, String city2) {
        DecimalFormat format=new DecimalFormat("0.00");
        String transport= TransportType.truck.getName();

        CenterLoadFormDataService dataserv= RMIHelper.getCenterloaddata();
        Weight weightgetter=new Weight();

        double weight=weightgetter.getweight(allbarcode);


        double singleprice=-1;
        try {
            singleprice=dataserv.getunitprice(transport);
        } catch (RemoteException e) {
            System.out.println("get single price failed while countint fee!!!");
            e.printStackTrace();
        }

        double distance=-1;
        try {
            distance=dataserv.getdistance(city1,city2);
        } catch (RemoteException e) {
            System.out.println("get distance failed while countint fee!!!");
            e.printStackTrace();
        }


        double fee=weight*singleprice*distance;
        fee=Double.valueOf(format.format(fee));
        return fee;
    }
}
