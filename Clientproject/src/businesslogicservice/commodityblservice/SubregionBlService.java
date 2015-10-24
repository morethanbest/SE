package businesslogicservice.commodityblservice;

import java.rmi.RemoteException;

import vo.ResultMessage;

import po.CommodityLocation;

public interface SubregionBlService {
	public ResultMessage Subregion(CommodityLocation beforeLocation,CommodityLocation afterLocation)throws RemoteException;
}
