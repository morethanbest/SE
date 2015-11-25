package businesslogic.logisticsbl.CenterloadPack;

import businesslogicservice.logisticsblservice.CenterloadBlService;
import po.ResultMessage;
import vo.CLFareVO;
import vo.CenterloadVO;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/25.
 */
public class CenterloadController implements CenterloadBlService{
    @Override
    public ResultMessage addCenterLoadForm(CenterloadVO vo) throws RemoteException {
        return null;
    }

    @Override
    public double computeCenterLoadFare(CLFareVO vo) throws RemoteException {
        return 0;
    }

    @Override
    public ResultMessage update(CenterloadVO vo) throws RemoteException {
        return null;
    }
}
