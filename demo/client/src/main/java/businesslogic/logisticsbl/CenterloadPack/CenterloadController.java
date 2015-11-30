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
    public ResultMessage addCenterLoadForm(CenterloadVO vo) throws RemoteException {
        AddCenterload add=new AddCenterload();
        Centerload contro=new Centerload(add);
        ResultMessage result=contro.addform(vo);



        return result;

    }



    @Override
    public List<CenterloadVO> findCenterloadForm(Formstate state,String orgcode) throws RemoteException {
        FindCenterload find=new FindCenterload();
        Centerload center=new Centerload(find);
        List<CenterloadVO>  list=center.findforms(state,orgcode);
        return list;
    }

    @Override
    public ResultMessage update(CenterloadVO vo) throws RemoteException {
        UpdateCenterload update=new UpdateCenterload();
        Centerload center=new Centerload(update);
        ResultMessage result=center.updateform(vo);

        CenterloadUpdateLogistics updatehistory=new CenterloadUpdateLogistics();
        updatehistory.updatehistory(vo);


        return result;
    }

    @Override
    public String getid(String orgcode,String date) throws RemoteException {
        Idget idgetter=new Idget();
        String id=idgetter.getid(orgcode,date);
        return id;
    }

    @Override
    public double getfee(CenterloadVO vo, String city1, String city2, String transport) {
        FeeCounter count=new FeeCounter();
        double fee=count.countfee(vo,city1,city2,transport);
        return fee;



    }
}
