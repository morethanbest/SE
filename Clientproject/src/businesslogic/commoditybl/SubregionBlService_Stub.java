package businesslogic.commoditybl;

import java.rmi.RemoteException;

import businesslogicservice.commodityblservice.SubregionBlService;
import po.CommodityLocation;
import vo.ResultMessage;

public class SubregionBlService_Stub implements SubregionBlService {

	@Override
	public ResultMessage Subregion(CommodityLocation beforeLocation, CommodityLocation afterLocation)
			throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

}
