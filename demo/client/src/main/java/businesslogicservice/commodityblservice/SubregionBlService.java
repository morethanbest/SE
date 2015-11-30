package businesslogicservice.commodityblservice;

import java.rmi.RemoteException;

import po.CommodityLocation;
import po.ResultMessage;

public interface SubregionBlService {
	public ResultMessage Subregion(String orgcode,CommodityLocation beforeLocation,CommodityLocation afterLocation)throws RemoteException;
}


     //可以考虑根据区号来进行调整 就是说 可以从一个区 移动 可选个数量的库存到另外一个区内
	 //   参数为  blocknum1   blocknum2   number（移动的库存的数量）
