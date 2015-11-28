package businesslogic.logisticsbl.GoodsRecevingPack;

import po.Arrivalstate;
import po.Formstate;
import po.GoodsReceivingPO;
import po.ResultMessage;
import vo.GoodsReceivingVO;

import java.util.List;

/**
 * Created by Administrator on 2015/11/27.
 */
public class GoodsReceving {
    AddGoods add;
    UpdateGoods update;

    FindGoods find;
    public GoodsReceving(AddGoods add){
        this.add=add;
    }

    public GoodsReceving (UpdateGoods update){
        this.update=update;
    }

    public GoodsReceving (FindGoods find){
        this.find=find;
    }


    public ResultMessage addgoodsform(GoodsReceivingVO vo){
        String id=vo.getid();
        long arrivaltime=vo.getArrivaltime();
        String transcode=vo.getTranscode();
        String departure=vo.getDeparture();
        Arrivalstate arrivalstate=vo.getArrivalstate();
        Formstate documentstate=vo.getFormstate();

        add.set(id,arrivaltime,transcode,departure,arrivalstate,documentstate);
        ResultMessage result=add.passadd();
        return result;
    }

    public ResultMessage updategoodsform(GoodsReceivingVO vo){
        String id=vo.getid();
        long arrivaltime=vo.getArrivaltime();
        String transcode=vo.getTranscode();
        String departure=vo.getDeparture();
        Arrivalstate arrivalstate=vo.getArrivalstate();
        Formstate documentstate=vo.getFormstate();

        update.set(id,arrivaltime,transcode,departure,arrivalstate,documentstate);
        ResultMessage result=update.passupdate();
        return result;
    }

    public List<GoodsReceivingVO> findgoodsform(Formstate state){
        List<GoodsReceivingPO> pos=find.getforms(state);
        List<GoodsReceivingVO> list=null;
        int len=pos.size();
        for(int i=0;i<=len-1;i++){
            GoodsReceivingPO po=pos.get(i);
            String id=po.getId();
            long arrivaltime=po.getArrivaltime();
            String transcode=po.getTranscode();
            String departure=po.getDeparture();
            Arrivalstate arrivalstate=po.getArrivalstate();
            Formstate documentstate=po.getDocumentstate();

            GoodsReceivingVO newvo=new GoodsReceivingVO(id,arrivaltime,transcode,departure,arrivalstate,documentstate);
            list.add(newvo);
        }
        return list;

    }

}
