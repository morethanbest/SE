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
    @Override
    public ResultMessage GoodsReceving(GoodsReceivingVO vo) {

        AddGoods add=new AddGoods();
        GoodsReceving goodsrev=new GoodsReceving(add);
        ResultMessage result=goodsrev.addgoodsform(vo);
        return result;

    }







    @Override
    public List<GoodsReceivingVO> findform(Formstate state,String orgcode)  {
        FindGoods find=new FindGoods();
        GoodsReceving rev=new GoodsReceving(find);
        List<GoodsReceivingVO> list=rev.findgoodsform(state,orgcode);
        return list;
    }

    @Override
    public ResultMessage updateFromHall(GoodsReceivingVO vo, String orgname) {
        GoodsRevUpdateLogistics updatelog=new GoodsRevUpdateLogistics();
        updatelog.updatabyhall(vo,orgname);////////////////////////////////////////////

        ResultMessage result=update(vo);
        return result;
    }

    @Override
    public ResultMessage updateFromCenter(GoodsReceivingVO vo, String orgname) {
        GoodsRevUpdateLogistics updatelog=new GoodsRevUpdateLogistics();
        updatelog.updatabyhall(vo,orgname);////////////////////////////////////////////

        ResultMessage result=update(vo);
        return result;
    }


    public ResultMessage update(GoodsReceivingVO vo) {


        UpdateGoods update=new UpdateGoods();
        GoodsReceving rev=new GoodsReceving(update);
        ResultMessage result=rev.updategoodsform(vo);
        return result;

    }

    @Override
    public String getid(String orgcode) {
        Idget idgetter=new Idget();
        String result=idgetter.getid(orgcode);
        return result;
    }
}
