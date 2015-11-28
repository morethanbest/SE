	package businesslogicservice.logisticsblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.ResultMessage;
import vo.GoodsReceivingVO;

public interface GoodsRecevingBlService {
	public ResultMessage GoodsRecevingFromhall (GoodsReceivingVO vo,String orgname)throws RemoteException;
	//orgname 为组织的名字     若营业厅接收到了营业厅来的货物 则调用这个方法
	public ResultMessage GoodsRecevingFromcenter(GoodsReceivingVO vo,String orgname)throws RemoteException;
	//营业厅接收到从中转中心的货物  则调用这个方法
	public List<GoodsReceivingVO> findform(Formstate state) throws  RemoteException;


	public ResultMessage update(GoodsReceivingVO vo)throws RemoteException;

	public String getid(String orgcode) throws  RemoteException;
}
