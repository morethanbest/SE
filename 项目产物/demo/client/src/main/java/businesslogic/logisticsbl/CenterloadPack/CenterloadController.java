package businesslogic.logisticsbl.CenterloadPack;

import businesslogicservice.logisticsblservice.CenterloadBlService;
import po.Formstate;
import po.ResultMessage;
import po.TransportType;
import vo.CLFareVO;
import vo.CenterloadVO;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Administrator on 2015/11/25.
 */
public class CenterloadController implements CenterloadBlService{
    @Override
    public ResultMessage addCenterLoadForm(CenterloadVO vo)  {
        AddCenterload add=new AddCenterload();
        Centerload contro=new Centerload(add);
        ResultMessage result=contro.addform(vo);



        return result;

    }



    @Override
    public List<CenterloadVO> findCenterloadForm(Formstate state,String orgcode)  {
        FindCenterload find=new FindCenterload();
        Centerload center=new Centerload(find);
        List<CenterloadVO>  list=center.findforms(state,orgcode);
        return list;
    }

    @Override
    public ResultMessage update(CenterloadVO vo) {
        UpdateCenterload update=new UpdateCenterload();
        Centerload center=new Centerload(update);
        ResultMessage result=center.updateform(vo);

        CenterloadUpdateLogistics updatehistory=new CenterloadUpdateLogistics();
        updatehistory.updatehistory(vo);


        return result;
    }

    @Override
    public String getid(String orgcode,long date)  {
        Idget idgetter=new Idget();
        String id=idgetter.getid(orgcode,date);
        return id;
    }

    @Override
    public double getfee(List<String> allbarcode, String city1, String city2) {
        FeeCounter count=new FeeCounter();
        double fee=count.countfee(allbarcode,city1,city2);
        return fee;



    }
}
