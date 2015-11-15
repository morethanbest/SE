package businesslogic.logisticsbl;

import java.rmi.RemoteException;
import java.util.List;

import po.ArrivalPO;
import po.LogisticsPO;
import po.RecordtransPO;
import vo.ArrivalVO;
import vo.ResultMessage;
import businesslogicservice.logisticsblservice.ArrivalBlService;
import dataservice.logisticsdataservice.ArrivalFormDataService;
import dataservice.logisticsdataservice.LogisticsInfoService;
import dataservice.logisticsdataservice.RecordtransFormDataService;

public class ArrivalBLServiceImpl implements ArrivalBlService{
	
	ArrivalFormDataService arrivalFormDataService;
	LogisticsInfoService logisticsInfoService;
	RecordtransFormDataService recordtransFormDataService;
	
	@Override
	public ResultMessage addArrival(ArrivalVO vo) {
		// TODO 这里需要找到数据库中的ArrivalPO的列表，然后生成最新的ID
		long newID;
		try {
			newID = arrivalFormDataService.findLastID() + 1;
			ArrivalPO po = new ArrivalPO(newID, vo.getCentercode(),vo.getArrivaltime(),vo.getTranscode(),vo.getDeparture(),vo.getArrivalstate());
		// TODO 这里需要在数据库中添加新的ArrivalPO，返回success
			arrivalFormDataService.addArrivalForm(po);
		} catch (RemoteException e) {
			return ResultMessage.failure;
		}
		return ResultMessage.success;
	}


	@Override
	public ResultMessage update(ArrivalVO vo) {
		// TODO 根据vo获得需要更改的订单号从数据库中拿到所有需要更改的LogisticsPO，ArrivalVO中可能存装车单编号或者中转单编号
		// TODO 修改过后将PO再放入数据库，返回success
		RecordtransPO temp;
		try {
			temp = recordtransFormDataService.getRecordtransForm(vo.getTranscode());
			List<String> orderList= temp.getAllcode();
			for (int i = 0; i < orderList.size(); i++) {
				LogisticsPO po = logisticsInfoService.findLogisticsInfo(orderList.get(i));
				List<String> history = po.getHistory();
				history.add("到达xxx中转中心");
				logisticsInfoService.update(po);
			}
		} catch (RemoteException e) {
			return ResultMessage.failure;
		}
		return ResultMessage.success;
	}

}
