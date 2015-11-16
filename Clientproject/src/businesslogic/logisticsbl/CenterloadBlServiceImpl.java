package businesslogic.logisticsbl;

import java.rmi.RemoteException;
import java.util.List;

import po.CenterloadPO;
import po.LogisticsPO;
import vo.CLFareVO;
import vo.CenterloadVO;
import vo.ResultMessage;
import businesslogicservice.logisticsblservice.CenterloadBlService;
import dataservice.logisticsdataservice.CenterLoadFormDataService;
import dataservice.logisticsdataservice.LogisticsInfoService;

public class CenterloadBlServiceImpl implements CenterloadBlService{
	
	CenterLoadFormDataService centerLoadFormDataService;
	LogisticsInfoService logisticsInfoService;
	
	@Override
	public ResultMessage addCenterLoadForm(CenterloadVO vo) {
		long newID;
		try {
			newID = centerLoadFormDataService.findLastID() + 1;
			CenterloadPO po = new CenterloadPO(newID, vo.getLoadtime(), vo.getMotorcode(), vo.getDestination(),
					vo.getVehiclecode(), vo.getSupervisor(), vo.getSupercargo(), vo.getAllbarcode(), computeCenterLoadFare(null));
		} catch (RemoteException e) {
			return ResultMessage.failure;
		}
		return ResultMessage.success;
	}

	@Override
	public double computeCenterLoadFare(CLFareVO vo) {
		// TODO 以后再实现吧。。。
		return 0;
	}

	@Override
	public ResultMessage update(CenterloadVO vo){
		try {
			List<String> orderList= vo.getAllbarcode();
			for (int i = 0; i < orderList.size(); i++) {
				LogisticsPO po = logisticsInfoService.findLogisticsInfo(orderList.get(i));
				List<String> history = po.getHistory();
				history.add("从xxx中转中心装车");
				logisticsInfoService.update(po);
			}
		} catch (RemoteException e) {
			return ResultMessage.failure;
		}
		return ResultMessage.success;
	}

}
