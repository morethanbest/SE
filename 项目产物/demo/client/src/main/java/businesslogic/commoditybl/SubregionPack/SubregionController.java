package businesslogic.commoditybl.SubregionPack;

import java.rmi.RemoteException;

import po.CommodityLocation;
import po.CommodityPO;
import po.ResultMessage;
import businesslogicservice.commodityblservice.SubregionBlService;

public class SubregionController implements SubregionBlService{



	@Override
	public ResultMessage Subregion(String orgcode,CommodityLocation beforeLocation,
			CommodityLocation afterLocation)  {
		// TODO Auto-generated method stub
		ChangeLocation change=new ChangeLocation();
		Subregion sub=new Subregion(change);
		ResultMessage result=sub.sub(orgcode,beforeLocation,afterLocation);
		return result;
	}

	@Override
	public boolean wheconflict(String orgcode,CommodityLocation location) {
		IsEmpty whe=new IsEmpty();
		boolean result=whe.wheEmpty(orgcode,location);
		return result;
	}


}
