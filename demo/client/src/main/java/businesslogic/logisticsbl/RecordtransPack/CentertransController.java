package businesslogic.logisticsbl.RecordtransPack;

import businesslogicservice.logisticsblservice.RecordtransBlService;
import dataservice.logisticsdataservice.RecordtransFormDataService;
import po.Formstate;
import po.RecordtransPO;
import po.ResultMessage;
import vo.RecordtransVO;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Administrator on 2015/11/26.
 */
public class CentertransController implements RecordtransBlService{
    @Override
    public ResultMessage Recordtrans(RecordtransVO vo) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage update(RecordtransVO vo) throws RemoteException {
        return null;
    }
}
