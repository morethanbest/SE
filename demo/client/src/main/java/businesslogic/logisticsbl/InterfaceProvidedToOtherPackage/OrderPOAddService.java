package businesslogic.logisticsbl.InterfaceProvidedToOtherPackage;

import po.LogisticsPO;
import po.ResultMessage;

/**
 * Created by Administrator on 2015/11/24.
 */
public interface OrderPOAddService {
    public ResultMessage addOrder(LogisticsPO po);

}
