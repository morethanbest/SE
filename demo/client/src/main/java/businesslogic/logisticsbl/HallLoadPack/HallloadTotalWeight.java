package businesslogic.logisticsbl.HallLoadPack;

import dataservice.logisticsdataservice.CenterLoadFormDataService;
import dataservice.logisticsdataservice.HallLoadFormDataService;
import init.RMIHelper;
import vo.CenterloadVO;
import vo.HallLoadVO;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Administrator on 2015/11/29.
 */
public class HallloadTotalWeight {
    public double getweight(List<String> barcode){
        HallLoadFormDataService data=RMIHelper.getHallloadform();
        int len=barcode.size();
        double totalweight=0;
        for(int i=0;i<=len-1;i++){
            double weight=0;
            try {
                weight=data.getweight(barcode.get(i));
            } catch (RemoteException e) {
                System.out.println("hallload count fee get weight failed!!!");
                e.printStackTrace();
            }
            totalweight=totalweight+weight;
        }

        return totalweight;

    }
}
