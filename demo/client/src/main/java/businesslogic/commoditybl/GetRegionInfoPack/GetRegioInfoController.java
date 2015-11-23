package businesslogic.commoditybl.GetRegionInfoPack;

import java.rmi.RemoteException;

import vo.Region;
import vo.RegionInfoVO;
import businesslogicservice.commodityblservice.GetRegionInfoBlService;

public class GetRegioInfoController implements GetRegionInfoBlService{

	

	@Override
	public RegionInfoVO getRegionInfo(long blocknum) throws RemoteException {
		// TODO Auto-generated method stub
		RegionGetMock regiongetter=new RegionGetMock(null);//change
		GetRegionInfo regioninfo=new GetRegionInfo(regiongetter);
		RegionInfoVO vo=regioninfo.getinfo(blocknum);
		return vo;
		
		}

}
