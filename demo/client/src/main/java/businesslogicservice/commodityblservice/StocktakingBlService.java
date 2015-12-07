package businesslogicservice.commodityblservice;

import java.rmi.RemoteException;
import java.util.List;

import vo.StocktakingVO;

public interface StocktakingBlService {

	//传入组织序号和分区序号， 此分区内的所有货物信息     进行库存盘点时  依次对各个区进行此项操作
	public StocktakingVO Stocktaking(String orgcode,long date,long blocknum);



	//每进行一次库存盘点 就调用一次这个方法  得到你这次盘点的批号
	public long getId(String orgcode,long date) ;


}
