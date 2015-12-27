package businesslogic.logisticsbl.HallLoadPack;

import businesslogic.logisticsbl.StategyPack.FeeInterface;
import businesslogic.logisticsbl.StategyPack.FeeStategyByTruck;

import java.util.List;

/**
 * Created by Administrator on 2015/11/29.
 */
public class HallFeeCount {
    public double countfee(List<String> allbarcode, String City1, String City2){
        FeeInterface feegetter=new FeeStategyByTruck();
        double result=feegetter.getfee(allbarcode, City1, City2);
        return result;
    }
}
