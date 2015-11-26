package businesslogic.logisticsbl.ArrivalPack;

import businesslogicservice.logisticsblservice.ArrivalBlService;
import po.ResultMessage;
import vo.ArrivalVO;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/25.
 */
public class ArrivalController implements ArrivalBlService {

    public ResultMessage addArrival(ArrivalVO vo) throws RemoteException {
        AddArrival addarriv=new AddArrival();
        Arrival newarriv=new Arrival(addarriv);
        ResultMessage result=newarriv.addArrivalForm(vo);
        return result;
    }

    @Override
    public ResultMessage addArrivalFromHall(ArrivalVO vo,String orgcode) throws RemoteException {
        ResultMessage result=addArrival(vo);
        UpdateLogistics update=new UpdateLogistics();
        ResultMessage res=update.updatebyhall(vo,orgcode);
        if(res==ResultMessage.failure){
            System.out.println("can not update all state");
        }
        return result;

    }

    @Override
    public ResultMessage addArrivalFromCenter(ArrivalVO vo,String orgcode) throws RemoteException {
        ResultMessage result=addArrival(vo);
        UpdateLogistics update=new UpdateLogistics();
        ResultMessage res=update.updatebycenter(vo,orgcode);
        if(res==ResultMessage.failure){
            System.out.println("can not update all state");
        }
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
    public long getid(String centercode) throws RemoteException {
        IdGet idgetter=new IdGet();
        long result=idgetter.getid(centercode);
        return result;
    }
}
