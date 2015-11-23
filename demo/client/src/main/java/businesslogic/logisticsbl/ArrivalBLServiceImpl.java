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
		// TODO ������Ҫ�ҵ����ݿ��е�ArrivalPO���б�Ȼ���������µ�ID
		long newID;
		try {
			newID = arrivalFormDataService.findLastID() + 1;
			ArrivalPO po = new ArrivalPO(newID, vo.getCentercode(),vo.getArrivaltime(),vo.getTranscode(),vo.getDeparture(),vo.getArrivalstate());
		// TODO ������Ҫ�����ݿ�������µ�ArrivalPO������success
			arrivalFormDataService.addArrivalForm(po);
		} catch (RemoteException e) {
			return ResultMessage.failure;
		}
		return ResultMessage.success;
	}


	@Override
	public ResultMessage update(ArrivalVO vo) {
		// TODO ����vo�����Ҫ���ĵĶ����Ŵ����ݿ����õ�������Ҫ���ĵ�LogisticsPO��ArrivalVO�п��ܴ�װ������Ż�����ת�����
		// TODO �޸Ĺ���PO�ٷ������ݿ⣬����success
		RecordtransPO temp;
		try {
			temp = recordtransFormDataService.getRecordtransForm(vo.getTranscode());
			List<String> orderList= temp.getAllcode();
			for (int i = 0; i < orderList.size(); i++) {
				LogisticsPO po = logisticsInfoService.findLogisticsInfo(orderList.get(i));
				List<String> history = po.getHistory();
				history.add("����xxx��ת����");
				logisticsInfoService.update(po);
			}
		} catch (RemoteException e) {
			return ResultMessage.failure;
		}
		return ResultMessage.success;
	}

}
