package businesslogicservice.commodityblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.ResultMessage;
import vo.StockinVO;

public interface InboundBlService {
	//在输入入库单时，当输入完成 点击确定按钮时  先调用wheoverload方法判断 是否会超出 警戒值 ，如果超出 提示是否加入分区 ，如果确定加入此分区  ，在调用inbound方法入库
	public boolean wheOverLoad(StockinVO vo ) throws  RemoteException;
	public ResultMessage Inbound(StockinVO vo)throws RemoteException;

	public ResultMessage update(StockinVO vo )throws  RemoteException;

	public List<StockinVO> findInboundForm(Formstate state,String orgcode)throws  RemoteException;

	public String getid(String orgcode)throws  RemoteException;
}
