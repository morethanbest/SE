package businesslogic.commoditybl.blstub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import po.CommodityLocation;

import businesslogicservice.commodityblservice.GetRegionInfoBlService;
import vo.CommodityGetRegionVO;
import vo.RegionInfoVO;

public class GetRegionInfoBlService_Stub implements GetRegionInfoBlService {

	@Override
	public RegionInfoVO getRegionInfo(long blocknum) throws RemoteException {
		// TODO Auto-generated method stub
		List<CommodityGetRegionVO> l=new ArrayList<CommodityGetRegionVO>();
		l.add(new CommodityGetRegionVO("a",1,new CommodityLocation(1,1,1,1)));
		return new RegionInfoVO(l);
	}

}
