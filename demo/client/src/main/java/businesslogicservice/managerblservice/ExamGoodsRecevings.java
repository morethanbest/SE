package businesslogicservice.managerblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.GoodsReceivingPO;
import po.ResultMessage;
import vo.GoodsReceivingExamVO;
import vo.GoodsReceivingVO;

public interface ExamGoodsRecevings {
	public List<GoodsReceivingVO> getGoodsReceivingForm (Formstate state);

	public ResultMessage updateGoodsReceivingForm (GoodsReceivingVO vo);

}
