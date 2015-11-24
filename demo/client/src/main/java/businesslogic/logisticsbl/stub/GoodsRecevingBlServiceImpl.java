package businesslogic.logisticsbl.stub;

import java.rmi.RemoteException;
import java.util.List;

import po.GoodsReceivingPO;
import po.LogisticsPO;
import po.RecordtransPO;
import vo.GoodsReceivingVO;
import vo.ResultMessage;
import businesslogicservice.logisticsblservice.GoodsRecevingBlService;
import dataservice.logisticsdataservice.GoodsReceivingFormDataService;
import dataservice.logisticsdataservice.LogisticsInfoService;
import dataservice.logisticsdataservice.RecordtransFormDataService;

public class GoodsRecevingBlServiceImpl implements GoodsRecevingBlService {

	GoodsReceivingFormDataService goodsReceivingFormDataService;
	LogisticsInfoService logisticsInfoService;
	RecordtransFormDataService recordtransFormDataService;
	
	@Override
	public ResultMessage GoodsReceving(GoodsReceivingVO vo) throws RemoteException {
		long newID;
		try {
			newID = goodsReceivingFormDataService.findLastID() + 1;
			GoodsReceivingPO po = new GoodsReceivingPO(newID, vo.getArrivaltime(), vo.getTranscode(), vo.getDeparture(), vo.getArrivalstate());
			goodsReceivingFormDataService.addGoodsReceivingForm(po);
		} catch (RemoteException e) {
			return ResultMessage.failure;
		}
		return ResultMessage.success;
	}

	@Override
	public ResultMessage update(GoodsReceivingVO vo) throws RemoteException {
		RecordtransPO temp;
		try {
			temp = recordtransFormDataService.getRecordtransForm(vo.getTranscode());
			List<String> orderList= temp.getAllcode();
			for (int i = 0; i < orderList.size(); i++) {
				LogisticsPO po = logisticsInfoService.findLogisticsInfo(orderList.get(i));
				List<String> history = po.getHistory();
				history.add("到达xxx营业厅");
				logisticsInfoService.update(po);
			}
		} catch (RemoteException e) {
			return ResultMessage.failure;
		}
		return ResultMessage.success;
	}

}
