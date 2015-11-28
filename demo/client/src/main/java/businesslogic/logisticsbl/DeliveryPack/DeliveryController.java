package businesslogic.logisticsbl.DeliveryPack;

import businesslogic.logisticsbl.stub.DeliveryBlServiceImpl;
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
    public ResultMessage Delivery(DeliveryVO vo) throws RemoteException {
        AddDelivery add=new AddDelivery();
        Delivery dev=new Delivery(add);
        ResultMessage result=dev.adddelivery(vo);
        return result;
    }

    @Override
    public List<DeliveryVO> find(Formstate state) throws RemoteException {
        FindDelivery finder=new FindDelivery();
        Delivery dev=new Delivery(finder);
        List<DeliveryVO> list=dev.find(state);
        return list;

    }

    @Override
    public String findID(String orgcode) throws RemoteException {
        IdGet idgetter=new IdGet();
        String id=idgetter.getid(orgcode);
        return id;

    }

    @Override
    public ResultMessage update(DeliveryVO vo) throws RemoteException {
        UpdateDelivery update=new UpdateDelivery();
        Delivery dev=new Delivery(update);
        ResultMessage result=dev.updatedelivery(vo);
        return result;
    }


}
