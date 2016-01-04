package businesslogicservice.commodityblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.CommodityLocation;
import po.Formstate;
import po.ResultMessage;
import vo.StockinVO;

public interface InboundBlService {
	//在输入入库单时，当输入完成 点击确定按钮时  先调用wheoverload方法判断 是否会超出 警戒值 ，如果超出 提示是否加入分区 ，如果确定加入此分区  ，在调用inbound方法入库
	public boolean wheOverLoad(StockinVO vo ) ;
	public ResultMessage Inbound(StockinVO vo);

	public ResultMessage update(StockinVO vo );

	public List<StockinVO> findInboundForm(Formstate state,String orgcode);

	public String getid(String orgcode);


	//	传入每个区的区号  得到 架号位号排号的上限
	public List<Long> getEachBlockLimit(long blocknum,String orgcode);
	//查看自己输入的库存位置是否已经有东西  true 为可以使用的空位置 false为已有
	public boolean wheConflict(String orgcode,CommodityLocation location);
}
