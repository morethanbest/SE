package businesslogic.commoditybl.InboundPack;

import dataservice.commoditydataservice.StockinFormDataService;
import init.RMIHelper;
import po.Formstate;
import po.StockinPO;
import vo.StockinVO;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Administrator on 2015/11/30.
 */
public class FindInbound {
    public List<StockinPO> findInboundForma(Formstate state,String orgcode){
        StockinFormDataService data= RMIHelper.getStockinform();
        List<StockinPO> pos=null;
        try {
            pos=data.getStockinForm(state,orgcode);
        } catch (RemoteException e) {
            System.out.println("get stockin forms by state failed!!!!");
            e.printStackTrace();
        }
        return pos;
    }
}
