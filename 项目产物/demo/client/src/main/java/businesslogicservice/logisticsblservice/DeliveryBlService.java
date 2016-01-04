package businesslogicservice.logisticsblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.ResultMessage;
import vo.DeliveryVO;

public interface DeliveryBlService {
	public ResultMessage Delivery(DeliveryVO vo);

	public List<DeliveryVO> find(Formstate state,String orgcode) ;

	public String findID(String orgcode) ;

	public ResultMessage update(DeliveryVO vo);




}
