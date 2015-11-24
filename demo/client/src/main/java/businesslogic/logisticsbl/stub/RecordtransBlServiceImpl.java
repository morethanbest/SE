package businesslogic.logisticsbl.stub;

import java.rmi.RemoteException;
import java.util.List;

import dataservice.logisticsdataservice.LogisticsInfoService;
import dataservice.logisticsdataservice.RecordtransFormDataService;
import po.LogisticsPO;
import po.RecordtransPO;
import vo.RecordtransVO;
import vo.ResultMessage;
import businesslogicservice.logisticsblservice.RecordtransBlService;

public class RecordtransBlServiceImpl implements RecordtransBlService {

	RecordtransFormDataService recordtransFormDataService;
	LogisticsInfoService logisticsInfoService;
	
	@Override
	public ResultMessage Recordtrans(RecordtransVO vo) throws RemoteException {
		long newID;
		try {
			newID = recordtransFormDataService.findLastID() + 1;
			RecordtransPO po = new RecordtransPO(newID, vo.getLoadtime(), vo.getArrivaltime(), vo.getTranscode(), vo.getFlightcode(),
					vo.getDepartrue(), vo.getDestination(), vo.getCountercode(), vo.getSupervisor(), vo.getAllcode(), 0);
			recordtransFormDataService.addRecordtransForm(po);
		} catch (RemoteException e) {
			return ResultMessage.failure;
		}
		return ResultMessage.success;
	}

	@Override
	public ResultMessage update(RecordtransVO vo) throws RemoteException {
		try {
			List<String> orderList= vo.getAllcode();
			for (int i = 0; i < orderList.size(); i++) {
				LogisticsPO po = logisticsInfoService.findLogisticsInfo(orderList.get(i));
				List<String> history = po.getHistory();
				history.add("xxx中转中心正在中转...");
				logisticsInfoService.update(po);
			}
		} catch (RemoteException e) {
			return ResultMessage.failure;
		}
		return ResultMessage.success;
	}

}
