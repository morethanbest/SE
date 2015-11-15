package businesslogic.commoditybl;

import java.rmi.RemoteException;

import vo.Region;
import vo.RegionInfoVO;
import businesslogicservice.commodityblservice.GetRegionInfoBlService;

public class GetRegioInfoController implements GetRegionInfoBlService{

	

	@Override
	public RegionInfoVO getRegionInfo(Region region) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
