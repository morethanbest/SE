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
    public ResultMessage addHallLoadForm(HallLoadVO vo)  {
        AddLoad add=new AddLoad();
        HallLoad load=new HallLoad(add);
        ResultMessage result=load.addform(vo);

        return result;
    }

    @Override
    public double computeHallLoadFare(HallLoadVO vo, String City1, String City2, String transporttype)  {
        HallFeeCount count=new HallFeeCount();
        double fee=count.countfee(vo,City1,City2,transporttype);
        return fee;
    }

    @Override
    public ResultMessage update(HallLoadVO vo)  {
        HallloadUpdateLogistics updatehistory=new HallloadUpdateLogistics();
        updatehistory.updatehistory(vo);

        UpdateLoad update=new UpdateLoad();
        HallLoad load=new HallLoad(update);
        ResultMessage result=load.updateform(vo);
        return result;
    }

    @Override
    public List<HallLoadVO> findforms(Formstate state,String orgcode)  {
        FindLoad find=new FindLoad();
        HallLoad load=new HallLoad(find);
        List<HallLoadVO> list=load.findforms(state,orgcode);
        return list;
    }

    @Override
    public String getid(String orgcode, long date) {
        Idget idgetter=new Idget();
        String id=idgetter.idget(orgcode,date);
        return id;
    }
}
