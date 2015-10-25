package businesslogic.commoditybl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import po.CommodityLocation;

import businesslogicservice.commodityblservice.GetRegionInfoBlService;
import vo.CommodityInVO;
import vo.Region;
import vo.RegionInfoVO;

public class GetRegionInfoBlService_Stub implements GetRegionInfoBlService {

	@Override
	public RegionInfoVO getRegionInfo(Region region) throws RemoteException {
		// TODO Auto-generated method stub
		List<CommodityInVO> l=new ArrayList<CommodityInVO>();
		l.add(new CommodityInVO("a",1,new CommodityLocation(1,1,1,1)));
		return new RegionInfoVO(l);
	}

}
