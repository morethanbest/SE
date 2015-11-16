package businesslogicservice.logisticsblservice;

import java.rmi.RemoteException;

import vo.ResultMessage; 

import vo.GoodsReceivingVO;

public interface GoodsRecevingBlService {
	public ResultMessage GoodsReceving (GoodsReceivingVO vo)throws RemoteException;
	public ResultMessage update(GoodsReceivingVO vo)throws RemoteException;
}
