package businesslogic.logisticsbl.RecordtransPack;

import dataservice.logisticsdataservice.RecordtransFormDataService;
import init.RMIHelper;
import vo.CenterloadVO;
import vo.RecordtransVO;

import java.rmi.RemoteException;
import java.text.DecimalFormat;

/**
 * Created by Administrator on 2015/11/28.
 */
public class FeeCount {

    public double getfee(RecordtransVO vo, String city1, String city2){
        TotalWeight getweight=new TotalWeight();
        String transporttype=vo.getTransportType();
        double weight=getweight.getweight(vo);
        RecordtransFormDataService data= RMIHelper.getRecordtrans();
        double singleprice=0;
        try {
            singleprice=data.getunitprice(transporttype);
        } catch (RemoteException e) {
            System.out.println("get single price failed!!!");
            e.printStackTrace();
        }
        double distance=0;
        try {
            distance=data.getdistance(city1,city2);
        } catch (RemoteException e) {
            System.out.println("get distance failed!!!");
            e.printStackTrace();
        }

        double fee=weight*singleprice*distance;
        DecimalFormat format=new DecimalFormat("0.00");
        fee=Long.valueOf(format.format(fee));
        return fee;


    }
}
