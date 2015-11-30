package businesslogic.commoditybl.GetRegionInfoPack;

import java.rmi.RemoteException;

import vo.Region;
import vo.RegionInfoVO;
import businesslogicservice.commodityblservice.GetRegionInfoBlService;

public class GetRegioInfoController implements GetRegionInfoBlService{

	

	@Override
	public RegionInfoVO getRegionInfo(String orgcode,long blocknum) throws RemoteException {
		// TODO Auto-generated method stub
		RegionGet geter=new RegionGet();
		GetRegionInfo regioninfo=new GetRegionInfo(geter);
		RegionInfoVO vo=regioninfo.getinfo(orgcode,blocknum);
		return vo;
		
		}

}
