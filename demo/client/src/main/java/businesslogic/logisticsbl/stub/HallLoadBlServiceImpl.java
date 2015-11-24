package businesslogic.logisticsbl.stub;

import java.rmi.RemoteException;
import java.util.List;

import po.HallLoadPO;
import po.LogisticsPO;
import vo.HLFareVO;
import vo.HallLoadVO;
import vo.ResultMessage;
import businesslogicservice.logisticsblservice.HallLoadBlService;
import dataservice.logisticsdataservice.HallLoadFormDataService;
import dataservice.logisticsdataservice.LogisticsInfoService;

public class HallLoadBlServiceImpl implements HallLoadBlService {

	HallLoadFormDataService hallLoadFormDataService;
	LogisticsInfoService logisticsInfoService;
	
	@Override
	public ResultMessage addHallLoadForm(HallLoadVO vo) throws RemoteException {
		long newID;
		try {
			newID = hallLoadFormDataService.findLastID() + 1;
			HallLoadPO po = new HallLoadPO(newID, vo.getLoadtime(), vo.getHallcode(), vo.getMotorcode(), vo.getDestination(),vo.getVehicldecode(), vo.getSupervisor(), vo.getSupercargo(), vo.getAllbarcode(), 0);
			hallLoadFormDataService.addLoadForm(po);
		} catch (RemoteException e) {
			return ResultMessage.failure;
		}
		return ResultMessage.success;
	}

	@Override
	public double computeHallLoadFare(HLFareVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultMessage update(HallLoadVO vo) throws RemoteException {
		try {
			List<String> orderList= vo.getAllbarcode();
			for (int i = 0; i < orderList.size(); i++) {
				LogisticsPO po = logisticsInfoService.findLogisticsInfo(orderList.get(i));
				List<String> history = po.getHistory();
				history.add("从xxx营业厅装车");
				logisticsInfoService.update(po);
			}
		} catch (RemoteException e) {
			return ResultMessage.failure;
		}
		return ResultMessage.success;
	}

}
