package businesslogicservice.commodityblservice;

import java.rmi.RemoteException;

import vo.RegionInfoVO;

public interface GetRegionInfoBlService {
	public RegionInfoVO getRegionInfo (Region region)throws RemoteException;
}
