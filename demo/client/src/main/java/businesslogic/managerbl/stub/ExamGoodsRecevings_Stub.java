package businesslogic.managerbl.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import businesslogicservice.managerblservice.ExamGoodsRecevings;
import po.Arrivalstate;
import vo.GoodsReceivingExamVO;
import vo.ResultMessage;

public class ExamGoodsRecevings_Stub implements ExamGoodsRecevings {

	@Override
	public List<GoodsReceivingExamVO> getGoodsRecevings() throws RemoteException {
		// TODO Auto-generated method stub
		List<GoodsReceivingExamVO> l=new ArrayList<GoodsReceivingExamVO>();
		l.add(new GoodsReceivingExamVO(1,"1",Hall.Nanjing,Arrivalstate.broken));
		return l;
	}

	@Override
	public ResultMessage GoodsRecevingsExam(List<GoodsReceivingExamVO> volist) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

}
