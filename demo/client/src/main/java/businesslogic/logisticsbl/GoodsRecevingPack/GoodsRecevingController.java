package businesslogic.logisticsbl.GoodsRecevingPack;

import businesslogic.logisticsbl.ArrivalPack.*;
import businesslogic.logisticsbl.ArrivalPack.UpdateLogistics;
import businesslogicservice.logisticsblservice.GoodsRecevingBlService;
import po.Formstate;
import po.ResultMessage;
import vo.GoodsReceivingVO;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Administrator on 2015/11/27.
 */
public class GoodsRecevingController implements GoodsRecevingBlService{

    public ResultMessage GoodsReceving(GoodsReceivingVO vo) throws RemoteException {

        AddGoods add=new AddGoods();
        GoodsReceving goodsrev=new GoodsReceving(add);
        ResultMessage result=goodsrev.addgoodsform(vo);
        return result;

    }



    @Override
    public ResultMessage GoodsRecevingFromhall(GoodsReceivingVO vo, String orgname) throws RemoteException {
        ResultMessage result=GoodsReceving(vo);
        GoodsRevUpdateLogistics updatelog=new GoodsRevUpdateLogistics();
        updatelog.updatabyhall(vo,orgname);////////////////////////////////////////////

        return result;


    }

    @Override
    public ResultMessage GoodsRecevingFromcenter(GoodsReceivingVO vo, String orgname) throws RemoteException {
        ResultMessage result=GoodsReceving(vo);
        GoodsRevUpdateLogistics updatelog=new GoodsRevUpdateLogistics();
        updatelog.updatebycenter(vo,orgname);
        return result;
    }

    @Override
    public List<GoodsReceivingVO> findform(Formstate state) throws RemoteException {
        FindGoods find=new FindGoods();
        GoodsReceving rev=new GoodsReceving(find);
        List<GoodsReceivingVO> list=rev.findgoodsform(state);
        return list;
    }

    @Override
    public ResultMessage update(GoodsReceivingVO vo) throws RemoteException {
        UpdateGoods update=new UpdateGoods();
        GoodsReceving rev=new GoodsReceving(update);
        ResultMessage result=rev.updategoodsform(vo);
        return result;

    }

    @Override
    public String getid(String orgcode) throws RemoteException {
        Idget idgetter=new Idget();
        String result=idgetter.getid(orgcode);
        return result;
    }
}
