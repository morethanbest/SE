package businesslogic.logisticsbl.LogisticsPack;

import businesslogicservice.logisticsblservice.SearchOrderBlService;
import vo.LogisticsVO;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/28.
 */
public class LogisticsSearchController implements SearchOrderBlService{


    @Override
    public LogisticsVO getOrderbyOrderNumber(String orderNumber) {
        Search searcher=new Search();
        LogisticsVO vo=searcher.searchorder(orderNumber);
        return vo;
    }
}
