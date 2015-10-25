package businesslogicservice.commodityblservice;

import java.rmi.RemoteException;

import vo.RegionInfoVO;

import vo.Region;

public interface GetRegionInfoBlService {
	public RegionInfoVO getRegionInfo (Region region)throws RemoteException;
}
