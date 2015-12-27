package businesslogic.logisticsbl.CenterloadPack;

import businesslogic.logisticsbl.StategyPack.FeeInterface;
import businesslogic.logisticsbl.StategyPack.FeeStategyByTruck;

import java.util.List;

/**
 * Created by Administrator on 2015/11/28.
 */
public class FeeCounter {

    public double countfee(List<String> allbarcode, String city1, String city2){
        FeeInterface feegetter=new FeeStategyByTruck();
        double result=feegetter.getfee(allbarcode, city1, city2);
        return result;

    }
}
