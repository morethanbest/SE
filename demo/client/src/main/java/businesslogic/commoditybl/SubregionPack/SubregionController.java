package businesslogic.commoditybl.SubregionPack;

import java.rmi.RemoteException;

import po.CommodityLocation;
import po.CommodityPO;
import vo.ResultMessage;
import businesslogicservice.commodityblservice.SubregionBlService;

public class SubregionController implements SubregionBlService{



	@Override
	public ResultMessage Subregion(CommodityLocation beforeLocation,
			CommodityLocation afterLocation) throws RemoteException {
		// TODO Auto-generated method stub
		CommodityPO po=new CommodityPO(11,"001220",20130412,beforeLocation,20140121);
		SubRegionMock newmock=new SubRegionMock(po);
		Subregion subre=new Subregion(newmock);
		ResultMessage result=subre.sub(beforeLocation, afterLocation);
		return result;
	}

	
	
}
