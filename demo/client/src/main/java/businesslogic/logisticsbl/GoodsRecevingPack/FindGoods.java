package businesslogic.logisticsbl.GoodsRecevingPack;

import dataservice.logisticsdataservice.GoodsReceivingFormDataService;
import init.RMIHelper;
import po.Arrivalstate;
import po.Formstate;
import po.GoodsReceivingPO;
import vo.GoodsReceivingVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/11/27.
 */
public class FindGoods {
    public List<GoodsReceivingPO> getforms(Formstate state,String orgcode) {
        GoodsReceivingFormDataService dataserv = RMIHelper.getGoodsreceiving();

        List<GoodsReceivingPO> pos = null;
        try {
            pos = dataserv.getGoodsReceivingForm(state,orgcode);
        } catch (RemoteException e) {
            System.out.println("find goodsrecevingforms by formstate failed!!!");
            e.printStackTrace();
        }

        return pos;
    }
}