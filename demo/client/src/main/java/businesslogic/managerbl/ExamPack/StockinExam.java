package businesslogic.managerbl.ExamPack;

import dataservice.managerdataservice.ExamDataService;
import init.RMIHelper;
import po.CommodityLocation;
import po.Formstate;
import po.ResultMessage;
import po.StockinPO;
import vo.StockinVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/8.
 */
public class StockinExam {
    public List<StockinVO> find(Formstate state){
        List<StockinPO> pos=null;
        ExamDataService data= RMIHelper.getExamdata();
        try {
            pos=data.getStockinForm(state);
        } catch (RemoteException e) {
            System.out.println("manager exam stock in forms get forms by state failed!!!");
            e.printStackTrace();
        }

        List<StockinVO> list=new ArrayList<StockinVO>();
        for(int i=0;i<=pos.size()-1;i++){
            StockinPO po=pos.get(i);
            String id=po.getId();
            String ordercode=po.getOrdercode();
            long intime=po.getIntime();
            CommodityLocation location=po.getLocation();
            String destination=po.getDestination();
            Formstate formstate=po.getFormstate();

            StockinVO vo=new StockinVO(id,ordercode,intime,location,destination,formstate);
            list.add(vo);
        }
        return list;
    }

    public ResultMessage update(StockinVO vo){
        ResultMessage result=null;
        ExamDataService data=RMIHelper.getExamdata();
        StockinPO po=new StockinPO(vo.getId(),vo.getOrdercode(),vo.getIntime(),vo.getLocation(),vo.getDestination(),vo.getFormstate());
        try {
            result=data.updateStockinForm(po);
        } catch (RemoteException e) {
            System.out.println("manager exam stock in  update forms failed!!!");
            e.printStackTrace();
        }
        return result;
    }
}
