package businesslogicservice.logisticsblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.ResultMessage;
import vo.DeliveryVO;

public interface DeliveryBlService {
	public ResultMessage Delivery(DeliveryVO vo)throws RemoteException;

	public List<DeliveryVO> find(Formstate state,String orgcode) throws  RemoteException;

	public String findID(String orgcode) throws  RemoteException;

	public ResultMessage update(DeliveryVO vo)throws RemoteException;




}
