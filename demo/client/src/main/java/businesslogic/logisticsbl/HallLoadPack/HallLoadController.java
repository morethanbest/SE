package businesslogic.logisticsbl.HallLoadPack;

import businesslogic.logisticsbl.RecordtransPack.*;
import businesslogicservice.logisticsblservice.HallLoadBlService;
import po.Formstate;
import po.ResultMessage;
import vo.HallLoadVO;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Administrator on 2015/11/28.
 */
public class HallLoadController implements HallLoadBlService{
    @Override
    public ResultMessage addHallLoadForm(HallLoadVO vo) throws RemoteException {
        AddLoad add=new AddLoad();
        HallLoad load=new HallLoad(add);
        ResultMessage result=load.addform(vo);
        HallloadUpdateLogistics updatehistory=new HallloadUpdateLogistics();
        updatehistory.updatehistory(vo);
        return result;
    }

    @Override
    public double computeHallLoadFare(HallLoadVO vo, String City1, String City2, String transporttype) throws RemoteException {
        HallFeeCount count=new HallFeeCount();
        double fee=count.countfee(vo,City1,City2,transporttype);
        return fee;
    }

    @Override
    public ResultMessage update(HallLoadVO vo) throws RemoteException {
        UpdateLoad update=new UpdateLoad();
        HallLoad load=new HallLoad(update);
        ResultMessage result=load.updateform(vo);
        return result;
    }

    @Override
    public List<HallLoadVO> findforms(Formstate state) throws RemoteException {
        FindLoad find=new FindLoad();
        HallLoad load=new HallLoad(find);
        List<HallLoadVO> list=load.findforms(state);
        return list;
    }

    @Override
    public String getid(String orgcode, String date) throws RemoteException {
        Idget idgetter=new Idget();
        String id=idgetter.idget(orgcode,date);
        return id;
    }
}
