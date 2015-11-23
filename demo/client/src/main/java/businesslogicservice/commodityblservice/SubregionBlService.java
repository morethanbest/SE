package businesslogicservice.commodityblservice;

import java.rmi.RemoteException;

import po.CommodityLocation;
import po.ResultMessage;

public interface SubregionBlService {
	public ResultMessage Subregion(CommodityLocation beforeLocation,CommodityLocation afterLocation)throws RemoteException;
}
