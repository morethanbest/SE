package businesslogic.managerbl.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import businesslogicservice.managerblservice.ExamGoodsRecevings;
import po.Arrivalstate;
import po.Hall;
import vo.GoodsRecevingExamVO;
import vo.ResultMessage;

public class ExamGoodsRecevings_Stub implements ExamGoodsRecevings {

	@Override
	public List<GoodsRecevingExamVO> getGoodsRecevings() throws RemoteException {
		// TODO Auto-generated method stub
		List<GoodsRecevingExamVO> l=new ArrayList<GoodsRecevingExamVO>();
		l.add(new GoodsRecevingExamVO(1,"1",Hall.Nanjing,Arrivalstate.broken));
		return l;
	}

	@Override
	public ResultMessage GoodsRecevingsExam(List<GoodsRecevingExamVO> volist) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

}
