package businesslogic.logisticsbl.RecordtransPack;

import businesslogic.logisticsbl.StategyPack.FeeInterface;
import businesslogic.logisticsbl.StategyPack.FeeStategyByPlane;
import businesslogic.logisticsbl.StategyPack.FeeStategyByTrain;
import businesslogic.logisticsbl.StategyPack.FeeStategyByTruck;
import dataservice.logisticsdataservice.RecordtransFormDataService;
import init.RMIHelper;
import vo.CenterloadVO;
import vo.RecordtransVO;

import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Administrator on 2015/11/28.
 */
public class FeeCount {

    public double getfee(List<String> allbarcode, String city1, String city2,String transporttype){


      double fee=0;
        if(transporttype.equals("火车")){
            FeeInterface feeget=new FeeStategyByTrain();
            fee=feeget.getfee(allbarcode,city1,city2);
        }
        else if(transporttype.equals("飞机")){
            FeeInterface feeget=new FeeStategyByPlane();
            fee=feeget.getfee(allbarcode,city1,city2);
        }
        else if(transporttype.equals("汽车")){
            FeeInterface feeget=new FeeStategyByTruck();
            fee=feeget.getfee(allbarcode,city1,city2);
        }
        return fee;


    }
}
