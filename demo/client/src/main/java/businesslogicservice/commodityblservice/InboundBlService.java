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


	//位置自动生成     填写入库单的时候  只要选择自己的区号 并且传入组织编号 就可以 得到这个区有空的位置
	public CommodityLocation getAvailLoc(String orgcode,long blocknum) ;

}
