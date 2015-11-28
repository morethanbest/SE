package businesslogic.logisticsbl.ArrivalPack;

import businesslogicservice.logisticsblservice.ArrivalBlService;
import po.Formstate;
import po.ResultMessage;
import vo.ArrivalVO;

import java.rmi.RemoteException;
import java.util.List;

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
    public ResultMessage addArrivalFromHall(ArrivalVO vo,String orgname) throws RemoteException {
        ResultMessage result=addArrival(vo);
        UpdateLogistics update=new UpdateLogistics();
        ResultMessage res=update.updatebyhall(vo,orgname);
        if(res==ResultMessage.failure){
            System.out.println("can not update all state");
        }
        return result;

    }

    @Override
    public ResultMessage addArrivalFromCenter(ArrivalVO vo,String orgname) throws RemoteException {
        ResultMessage result=addArrival(vo);
        UpdateLogistics update=new UpdateLogistics();
        ResultMessage res=update.updatebycenter(vo,orgname);
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
    public List<ArrivalVO> search(Formstate state) throws RemoteException {
        FindArrival find=new FindArrival();
        Arrival newarriv=new Arrival(find);
        List<ArrivalVO> list=newarriv.findArrivalForm(state);
        return list;
    }


    @Override
    public String getid(String orgcode) throws RemoteException {
        IdGet idgetter=new IdGet();
        String  result=idgetter.getid(orgcode);

        return result;
    }
}
