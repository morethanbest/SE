	package businesslogicservice.logisticsblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.ResultMessage;
import vo.GoodsReceivingVO;

public interface GoodsRecevingBlService {


	public ResultMessage GoodsReceving(GoodsReceivingVO vo)throws RemoteException;
	//营业厅接收到从中转中心的货物  则调用这个方法
	public List<GoodsReceivingVO> findform(Formstate state,String orgcode) throws  RemoteException;


	public ResultMessage updateFromHall(GoodsReceivingVO vo,String orgname)throws RemoteException;

	public ResultMessage updateFromCenter(GoodsReceivingVO vo,String orgname) throws  RemoteException;

	public String getid(String orgcode) throws  RemoteException;
}
