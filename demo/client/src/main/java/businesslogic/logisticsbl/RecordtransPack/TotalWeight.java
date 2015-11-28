package businesslogic.logisticsbl.RecordtransPack;

import dataservice.logisticsdataservice.RecordtransFormDataService;
import init.RMIHelper;
import vo.RecordtransVO;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Administrator on 2015/11/28.
 */
public class TotalWeight {
    public double getweight(RecordtransVO vo){
        RecordtransFormDataService data= RMIHelper.getRecordtrans();
        List<String> allbar=vo.getAllcode();
        double totalweight=0;
        for(int i=0;i<=allbar.size()-1;i++){
            double weight=0;
            try {
                weight=data.getweight(allbar.get(i));
            } catch (RemoteException e) {
                System.out.println("Recordtrans get weight failed!!");
                e.printStackTrace();
            }
            totalweight=totalweight+weight;
        }
        return totalweight;

    }
}
