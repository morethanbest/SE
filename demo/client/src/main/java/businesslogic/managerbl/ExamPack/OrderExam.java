package businesslogic.managerbl.ExamPack;

import dataservice.managerdataservice.ExamDataService;
import init.RMIHelper;
import po.Formstate;
import po.OrderPO;
import po.Ordertype;
import po.ResultMessage;
import vo.OrderVO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/8.
 */
public class OrderExam {
    public List<OrderVO> find(Formstate state){
        List<OrderPO> pos=null;
        List<OrderVO> list=new ArrayList<OrderVO>();
        ExamDataService data= RMIHelper.getExamdata();
        try {
            pos=data.getOrderForm(state);

            for(int i=0;i<=pos.size()-1;i++){
                OrderPO po=pos.get(i);
                String sendername=po.getSendername();
                String senderaddress=po.getSenderaddress();
                String senderunit=po.getSenderunit();
                String senderphone=po.getSenderphone();
                String sendercellphone=po.getSendercellphone();
                String receivername=po.getReceivername();
                String receiveraddress=po.getReceiveraddress();
                String receiverunit=po.getReceiverunit();
                String receiverphone=po.getReceiverphone();
                String receivercellphone=po.getReceivercellphone();
                double numbers=po.getNumbers();
                double weight=po.getWeight();
                double volume=po.getVolume();
                String productname=po.getProductname();
                String packagetype=po.getPackagetype();
                String ordercode=po.getOrdercode();
                Ordertype ordertype=po.getOrdertype();
                double totalfee=po.getTotalfee();
                Formstate documentstate=po.getDocumentstate();

                OrderVO vo= new OrderVO(sendername,senderaddress,senderunit,senderphone,sendercellphone,receivername,
                        receiveraddress,receiverunit,receiverphone,receivercellphone,numbers,weight,volume,productname,
                        packagetype,ordercode,ordertype,totalfee,documentstate);
                list.add(vo);
            }

        } catch (RemoteException e) {
            System.out.println("manager exam order get forms by state failed!!!");
            e.printStackTrace();
        }



        return list;
    }

    public ResultMessage update(OrderVO vo){
        ResultMessage result=null;
        ExamDataService data=RMIHelper.getExamdata();
        OrderPO newpo=null;
        try {
            newpo=data.getpo(vo.getOrdercode());
        } catch (RemoteException e) {
            System.out.println("manager exam order get orderpo by ordercode failed!!!");
            e.printStackTrace();
        }

        OrderPO po=new OrderPO(newpo.getOrgcode(),vo.getSendername(),vo.getSenderaddress(),vo.getSenderunit()
                ,vo.getSenderphone(),vo.getSendercellphone(),vo.getReceivername(),vo.getReceiveraddress(),vo.getReceiverunit()
                ,vo.getReceiverphone(),vo.getReceivercellphone(),vo.getNumbers(),vo.getWeight(),vo.getVolume(),
                vo.getProductname(),vo.getPackagetype(),vo.getTotalfee(),vo.getOrdercode(),vo.getOrdertype(),
                newpo.getCodeofreceiving(),newpo.getReceiver(),newpo.getReceivingtime(),vo.getFormstate());

        try {
            result=data.updateOrderForm(po);
        } catch (RemoteException e) {
            System.out.println("manager exam order update forms failed!!!");
            e.printStackTrace();
        }
        return result;
    }
}
