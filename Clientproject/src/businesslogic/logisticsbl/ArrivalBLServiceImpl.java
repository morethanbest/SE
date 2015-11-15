package businesslogic.logisticsbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import vo.ArrivalVO;
import vo.ResultMessage;
import businesslogic.logisticsbl.mock.MockArrival;
import businesslogic.logisticsbl.mock.MockLogistics;
import businesslogicservice.logisticsblservice.ArrivalBlService;

public class ArrivalBLServiceImpl implements ArrivalBlService{
	
	@Override
	public ResultMessage addArrival(ArrivalVO vo) throws RemoteException {
		// TODO ������Ҫ�ҵ����ݿ��е�ArrivalPO���б�Ȼ���������µ�ID
		MockArrival mock = new MockArrival(4);
		// TODO ������Ҫ�����ݿ�������µ�ArrivalPO������success
		return ResultMessage.success;
	}


	@Override
	public ResultMessage update(ArrivalVO vo) throws RemoteException {
		// TODO ����vo�����Ҫ���ĵĶ����Ŵ����ݿ����õ�������Ҫ���ĵ�LogisticsPO��ArrivalVO�п��ܴ�װ������Ż�����ת�����
		List<String> list = new ArrayList<String>();
		list.add("�ɼ���");
		list.add("�����Ͼ���ϼӪҵ��");
		MockLogistics mock = new MockLogistics("�����Ͼ���ת����", list, "5436475");
		// TODO �޸Ĺ���PO�ٷ������ݿ⣬����success
		return ResultMessage.success;
	}

}
