package businesslogic.logisticsbl.ArrivalPack;

import businesslogicservice.logisticsblservice.ArrivalBlService;
import po.ResultMessage;
import vo.ArrivalVO;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/25.
 */
public class ArrivalController implements ArrivalBlService {
    @Override
    public ResultMessage addArrival(ArrivalVO vo) throws RemoteException {
        AddArrival addarriv=new AddArrival();
        Arrival newarriv=new Arrival(addarriv);
        ResultMessage result=newarriv.addArrivalForm(vo);
        return result;
    }

    @Override
    public ResultMessage update(ArrivalVO vo) throws RemoteException {
        UpdateArrival updatearriv=new UpdateArrival();
        Arrival newarriv=new Arrival(updatearriv);
        ResultMessage result=newarriv.updataArrivalForm(vo);
        return result;
    }
}
