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
		// TODO 这里需要找到数据库中的ArrivalPO的列表，然后生成最新的ID
		MockArrival mock = new MockArrival(4);
		// TODO 这里需要在数据库中添加新的ArrivalPO，返回success
		return ResultMessage.success;
	}


	@Override
	public ResultMessage update(ArrivalVO vo) throws RemoteException {
		// TODO 根据vo获得需要更改的订单号从数据库中拿到所有需要更改的LogisticsPO，ArrivalVO中可能存装车单编号或者中转单编号
		List<String> list = new ArrayList<String>();
		list.add("派件中");
		list.add("到达南京栖霞营业厅");
		MockLogistics mock = new MockLogistics("到达南京中转中心", list, "5436475");
		// TODO 修改过后将PO再放入数据库，返回success
		return ResultMessage.success;
	}

}
