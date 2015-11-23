package businesslogic.managerbl.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import po.City;
import po.CommodityLocation;

import businesslogicservice.managerblservice.ExamInbounds;
import vo.ResultMessage;
import vo.StockinExamVO;

public class ExamInbounds_Stub implements ExamInbounds {

	@Override
	public List<StockinExamVO> getInbounds() throws RemoteException {
		// TODO Auto-generated method stub
		List<StockinExamVO> l=new ArrayList<StockinExamVO>();
		l.add(new StockinExamVO("1",1,new CommodityLocation(1,1,1,1),City.Beijing));
		return l;
	}

	@Override
	public ResultMessage InboundsExam(List<StockinExamVO> volist) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

}
