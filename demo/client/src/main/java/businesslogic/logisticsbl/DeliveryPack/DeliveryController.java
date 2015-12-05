package businesslogic.logisticsbl.DeliveryPack;


import businesslogicservice.logisticsblservice.DeliveryBlService;
import po.Formstate;
import po.ResultMessage;
import vo.DeliveryVO;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Administrator on 2015/11/26.
 */
public class DeliveryController implements DeliveryBlService{
    @Override
    public ResultMessage Delivery(DeliveryVO vo) {
        AddDelivery add=new AddDelivery();
        Delivery dev=new Delivery(add);
        ResultMessage result=dev.adddelivery(vo);
        return result;
    }

    @Override
    public List<DeliveryVO> find(Formstate state,String orgcode) {
        FindDelivery finder=new FindDelivery();
        Delivery dev=new Delivery(finder);
        List<DeliveryVO> list=dev.find(state,orgcode);
        return list;

    }

    @Override
    public String findID(String orgcode) {
        IdGet idgetter=new IdGet();
        String id=idgetter.getid(orgcode);
        return id;

    }

    @Override
    public ResultMessage update(DeliveryVO vo) {
        UpdateDelivery update=new UpdateDelivery();
        Delivery dev=new Delivery(update);
        ResultMessage result=dev.updatedelivery(vo);
        return result;
    }


}
