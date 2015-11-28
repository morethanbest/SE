package businesslogic.logisticsbl.CenterloadPack;

import dataservice.logisticsdataservice.CenterLoadFormDataService;
import init.RMIHelper;
import vo.CenterloadVO;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Administrator on 2015/11/28.
 */
public class TotalWeight {

    public double getweight(CenterloadVO vo){
        CenterLoadFormDataService dataserv= RMIHelper.getCenterloaddata();
        List<String> barcode=vo.getAllbarcode();
        int len=barcode.size();
        double totalweight=0;
        for(int i=0;i<=len-1;i++){
            double weight=0;
            try {
                weight=dataserv.getweight(barcode.get(i));
            } catch (RemoteException e) {
                System.out.println("centerload count fee get weight failed!!!");
                e.printStackTrace();
            }
            totalweight=totalweight+weight;
        }

        return totalweight;

    }
}
