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

    @Override
    public String getDepartureByTrans(String transcode) throws RemoteException {
        DepartGet departgetter=new DepartGet();
        String departure=departgetter.getDepartureByTrans(transcode);
        return departure;
    }

    @Override
    public String getDepartureByLoad(String loadcode) throws RemoteException {
        DepartGet departgetter=new DepartGet();
        String departure=departgetter.getDepartureByLoad(loadcode);
        return departure;
    }

    @Override
    public String getid(String centercode) throws RemoteException {
        IdGet idgetter=new IdGet();
        String result=idgetter.getid(centercode);
        return result;
    }
}
