package businesslogic.commoditybl;

import java.rmi.RemoteException;

import po.CommodityLocation;
import vo.ResultMessage;
import businesslogicservice.commodityblservice.SubregionBlService;

public class SubregionController implements SubregionBlService{



	@Override
	public ResultMessage Subregion(CommodityLocation beforeLocation,
			CommodityLocation afterLocation) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
