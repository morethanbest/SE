package businesslogic.logisticsbl.DeliveryPack;

import businesslogic.logisticsbl.stub.DeliveryBlServiceImpl;
import businesslogicservice.logisticsblservice.DeliveryBlService;
import po.ResultMessage;
import vo.DeliveryVO;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/26.
 */
public class DeliveryController implements DeliveryBlService{
    @Override
    public ResultMessage Delivery(DeliveryVO vo) throws RemoteException {
        AddDelivery add=new AddDelivery();
        Delivery dev=new Delivery(add);
        ResultMessage result=dev.adddelivery(vo);
        return result;
    }

    @Override
    public ResultMessage update(DeliveryVO vo) throws RemoteException {
        UpdateDelivery update=new UpdateDelivery();
        Delivery dev=new Delivery(update);
        ResultMessage result=dev.updatedelivery(vo);
        return result;
    }


}
