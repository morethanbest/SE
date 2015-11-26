package businesslogic.logisticsbl.stub;

import java.rmi.RemoteException;
import java.util.List;

import po.StringLoadPO;
import po.LogisticsPO;
import vo.HLFareVO;
import vo.StringLoadVO;
import vo.ResultMessage;
import businesslogicservice.logisticsblservice.StringLoadBlService;
import dataservice.logisticsdataservice.StringLoadFormDataService;
import dataservice.logisticsdataservice.LogisticsInfoService;

public class StringLoadBlServiceImpl implements StringLoadBlService {

	StringLoadFormDataService hallLoadFormDataService;
	LogisticsInfoService logisticsInfoService;
	
	@Override
	public ResultMessage addStringLoadForm(StringLoadVO vo) throws RemoteException {
		long newID;
		try {
			newID = hallLoadFormDataService.findLastID() + 1;
			StringLoadPO po = new StringLoadPO(newID, vo.getLoadtime(), vo.getStringcode(), vo.getMotorcode(), vo.getDestination(),vo.getVehicldecode(), vo.getSupervisor(), vo.getSupercargo(), vo.getAllbarcode(), 0);
			hallLoadFormDataService.addLoadForm(po);
		} catch (RemoteException e) {
			return ResultMessage.failure;
		}
		return ResultMessage.success;
	}

	@Override
	public double computeStringLoadFare(HLFareVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultMessage update(StringLoadVO vo) throws RemoteException {
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
