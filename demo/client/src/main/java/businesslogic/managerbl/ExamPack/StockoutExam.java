package businesslogic.managerbl.ExamPack;

import dataservice.managerdataservice.ExamDataService;
import init.RMIHelper;
import po.Formstate;
import po.ResultMessage;
import po.StockoutPO;
import vo.StockoutVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/8.
 */
public class StockoutExam {
    public List<StockoutVO> find(Formstate state){
        List<StockoutPO> pos=null;
        ExamDataService data= RMIHelper.getExamdata();
        try {
            pos=data.getStockoutForm(state);
        } catch (RemoteException e) {
            System.out.println("manager exam stock out get forms by state failed@!!!");
            e.printStackTrace();
        }
        List<StockoutVO> list=new ArrayList<StockoutVO>();
        for(int i=0;i<=pos.size()-1;i++){
            StockoutPO po=pos.get(i);
            String id=po.getId();
            String ordercode=po.getOrdercode();
            long outtime=po.getOuttime();
            String destination=po.getDestination();
            String transporttype=po.getTransporttype();
            String transcode=po.getTranscode();
            Formstate formstate=po.getFormstate();

            StockoutVO vo=new StockoutVO(id,ordercode,outtime,destination,transporttype,transcode,formstate);
            list.add(vo);
        }
        return list;
    }

    public ResultMessage update(StockoutVO vo){
        ResultMessage result=null;
        ExamDataService data=RMIHelper.getExamdata();
        StockoutPO po=new StockoutPO(vo.getId(),vo.getOrdercode(),vo.getOuttime(),vo.getDestination(),vo.getTransportType()
        ,vo.getTranscode(),vo.getFormstate());
        try {
            result=data.updateStockoutForm(po);
        } catch (RemoteException e) {
            System.out.println("manager exam stockout update forms failed!!!");
            e.printStackTrace();
        }
        return result;
    }
}
