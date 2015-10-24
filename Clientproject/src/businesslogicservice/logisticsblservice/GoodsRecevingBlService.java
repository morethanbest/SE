package businesslogicservice.logisticsblservice;

import java.rmi.RemoteException;

import vo.ResultMessage; 

import vo.GoodsRecevingVO;

public interface GoodsRecevingBlService {
	public ResultMessage GoodsReceving (GoodsRecevingVO vo)throws RemoteException;

}
